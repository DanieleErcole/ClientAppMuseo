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


public class DataManager {

    private final String hostname;
    private String url;
    private HttpURLConnection httpConnection;

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

    public URL requestFile(String url, String directory) throws MalformedURLException {
        StringBuilder requestUrl = new StringBuilder("http://" + hostname + ":80/TestAppMuseo/Risorse/" + directory + "/" + url);
        return new URL(requestUrl.toString());
    }

}
