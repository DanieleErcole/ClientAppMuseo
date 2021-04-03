package main.database;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DataManager {

    private final String hostname;
    private String url; //request-script.php
    private HttpURLConnection httpConnection;

    public DataManager(String hostname, String url) {
        this.hostname = hostname;
        this.url = url;
    }

    public <T> T requestData(Class<T> dataClass, HashMap<String, String> params) throws IOException {
        StringBuilder requestUrl = new StringBuilder("http://" + hostname + ":80/!User-files/TestAppMuseo/" + url + "?");
        for(Map.Entry e : params.entrySet())
            requestUrl.append(e.getKey()).append("=").append(e.getValue());

        InputStream stream;
        httpConnection = (HttpURLConnection) new URL(requestUrl.toString()).openConnection();
        httpConnection.setRequestProperty("accept", "application/json");
        stream = httpConnection.getInputStream();

        ObjectMapper mapper = new ObjectMapper();
        T object = mapper.readValue(stream, dataClass);
        stream.close();
        httpConnection.disconnect();
        return object;
    }

    public Image requestImage(String url, HashMap<String, String> params) throws IOException {
        StringBuilder requestUrl = new StringBuilder("http://" + hostname + ":80/TestAppMuseo/Risorse/Immagini/" + url + "?");
        for(Map.Entry e : params.entrySet())
            requestUrl.append(e.getKey()).append("=").append(e.getValue());

        InputStream stream;
        httpConnection = (HttpURLConnection) new URL(requestUrl.toString()).openConnection();
        stream = httpConnection.getInputStream();

        Image img = ImageIO.read(stream);
        stream.close();
        httpConnection.disconnect();
        return img;
    }

    public File requestFile(String url, HashMap<String, String> params, String filename) throws IOException {
        StringBuilder requestUrl = new StringBuilder("http://" + hostname + ":80/TestAppMuseo/" + url + "?");
        for(Map.Entry e : params.entrySet())
            requestUrl.append(e.getKey()).append("=").append(e.getValue());

        InputStream stream;
        httpConnection = (HttpURLConnection) new URL(requestUrl.toString()).openConnection();
        stream = httpConnection.getInputStream();

        File file = null;

        int length = httpConnection.getContentLength();
        if(length > 0) {
            byte serverData[] = new byte[length];
            stream.read(serverData);
            FileOutputStream outputStream = new FileOutputStream(this.getDirectory(
                    FileSystemView.getFileSystemView().getDefaultDirectory().listFiles()).getPath() + "/" + filename
            );
            outputStream.write(serverData);
            file = new File(this.getDirectory(
                    FileSystemView.getFileSystemView().getDefaultDirectory().listFiles()).getPath() + "/" + filename);
        }
        stream.close();
        httpConnection.disconnect();
        return file;
    }

    public String insertFile(File fileToInsert) {
        try {
            File documentsDirectory = FileSystemView.getFileSystemView().getDefaultDirectory();
            File[] listFiles = documentsDirectory.listFiles();

            File saveDirectory = this.getDirectory(listFiles);
            if(saveDirectory != null) {
                File[] saveFiles = saveDirectory.listFiles();
                for(File file : saveFiles)
                    if(file.getName().equals(fileToInsert.getName()))
                        System.out.println("- File deleted: " + file.delete() + ";");
            } else {
                saveDirectory = new File(documentsDirectory.getPath() + "/AppMuseoResources");
                System.out.println("- Directory created: " + saveDirectory.mkdir() + ";");
            }

            String pathString = saveDirectory.getPath() + "/" + fileToInsert.getName();
            FileOutputStream outputStream = new FileOutputStream(saveDirectory.getPath() + "/" + fileToInsert.getName());
            ObjectOutputStream objectStream = new ObjectOutputStream(outputStream);
            objectStream.writeObject(fileToInsert);

            objectStream.flush();
            objectStream.close();
            outputStream.flush();
            outputStream.close();
            return pathString;
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private File getDirectory(File[] files) {
        for(File file : files)
            if(file.getName().equals("AppMuseoResources") && file.isDirectory())
                return file;
        return null;
    }

    //Setter
    public void setURL(String url) {
        this.url = url;
    }

}
