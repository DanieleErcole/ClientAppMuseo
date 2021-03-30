package main.database;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DataManager {

    private final String hostname;
    private final String url; // request-script.php
    private HttpURLConnection httpConnection;

    public DataManager(String hostname, String url) {
        this.hostname = hostname;
        this.url = url;
    }

    public <T> T requestData(Class<T> dataClass, HashMap<String, String> params) throws IOException {
        StringBuilder requestUrl = new StringBuilder(url + "?");
        for(Map.Entry e : params.entrySet())
            requestUrl.append(e.getKey()).append("=").append(e.getValue());

        InputStream stream;
        httpConnection = (HttpURLConnection) new URL(url).openConnection();
        httpConnection.setRequestProperty("accept", "application/json");
        stream = httpConnection.getInputStream();

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(stream, dataClass);
    }

}
