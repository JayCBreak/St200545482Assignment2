package com.example.st200545482assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {
    /**
     * This function gets the server data given an IP or hostname of a server with an optional port
     * Format - [hostname], or [IP], or [hostname:port], or [IP:port].
     * @param serverIp The IP/hostname of the server to connect to. If given a port such as :25565 it will use it,
     *                 however the API also autocompletes the port itself.
     * @return An object containing details of the server requested.
     * @throws IOException
     * @throws InterruptedException
     */
    public static McSrvResponse callMcSrvAPI(String serverIp) throws IOException, InterruptedException {
        //Remove any spaces because that would create an invalid IP address
        serverIp = serverIp.trim().replaceAll(" ", "");

        //no key required, API is entirely donation based
        String uri = "https://api.mcsrvstat.us/3/" + serverIp;

        //configure the environment to make a HTTP request (update module-info.java)
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
                .ofString());

        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), McSrvResponse.class);
    }

    /**
     * This function reads the example server shown in server.json. It is from my own server when a few people were on it.
     * @return An object containing the example server.
     */
    public static McSrvResponse getExampleServer() {
        Gson gson = new Gson();
        try (
                FileReader fileReader = new FileReader("server.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            return gson.fromJson(jsonReader, McSrvResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // I had a method for calling the Crafatar API to get player faces, but it just returns PNGs when given
    // Minecraft UUID's instead of any json data, so it's easier to just implement it in the Model
}
