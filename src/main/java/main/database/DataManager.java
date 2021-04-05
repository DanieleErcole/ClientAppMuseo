package main.database;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe che gestisce le richieste dei file, delle immagini e degli oggetti al server
 * @author Daniele Pelizzoni e Simone Raffo
 */
public class DataManager {

    private final String hostname;
    private String url;
    private HttpURLConnection httpConnection;

    /**
     * Costruttore degli oggetti di classe DataManager
     * @param hostname nome del server
     * @param url percorso del file php da richiedere
     */
    public DataManager(String hostname, String url) {
        this.hostname = hostname;
        this.url = url;
    }

    /**
     * Metodo che invia una richiesta al server (metodo GET), che risponderà con un formato .json, che verrà convertito in un'istanza
     * della classe specificata come parametro
     * @param dataClass classe dell'oggetto da richiedere
     * @param params parametri da inviare al server
     * @param <T> tipo di oggetto da richiedere
     * @return Oggetto convertito
     * @throws IOException
     */
    public <T> T requestData(Class<T> dataClass, HashMap<String, String> params) throws IOException {
        StringBuilder requestUrl = new StringBuilder("http://" + hostname + ":80/TestAppMuseo/" + url + "?");
        for(Map.Entry e : params.entrySet()) {
            requestUrl.append(e.getKey()).append("=").append(e.getValue());
            if(params.entrySet().size() > 1)
                requestUrl.append("&");
        }

        InputStream stream;
        httpConnection = (HttpURLConnection) new URL(requestUrl.toString()).openConnection();
        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("accept", "application/json");
        stream = httpConnection.getInputStream();

        ObjectMapper mapper = new ObjectMapper();
        T object = mapper.readValue(stream, dataClass);
        stream.close();
        httpConnection.disconnect();
        return object;
    }

    /**
     * Metodo che richiede un'immagine al server
     * @param url url dell'immagine
     * @return l'immagine richiesta
     * @throws IOException
     */
    public Image requestImage(String url) throws IOException {
        StringBuilder requestUrl = new StringBuilder("http://" + hostname + ":80/TestAppMuseo/Risorse/Immagini/" + url);
        InputStream stream;
        httpConnection = (HttpURLConnection) new URL(requestUrl.toString()).openConnection();
        stream = httpConnection.getInputStream();

        Image img = ImageIO.read(stream);
        stream.close();
        httpConnection.disconnect();
        return img;
    }

    /**
     * Metodo che richiede un file al server
     * @param name nome del file
     * @param directory directory del serve dentro la quale cercare (definisce il tipo di file)
     * @return percorso del file
     * @throws MalformedURLException
     */
    public URL requestFile(String name, String directory) throws MalformedURLException {
        StringBuilder requestUrl = new StringBuilder("http://" + hostname + ":80/TestAppMuseo/Risorse/" + directory + "/" + name);
        return new URL(requestUrl.toString());
    }

}
