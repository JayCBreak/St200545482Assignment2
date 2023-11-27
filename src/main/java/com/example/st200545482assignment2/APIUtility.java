package com.example.st200545482assignment2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {
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

        System.out.println(httpResponse.body());

        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), McSrvResponse.class);
    }

    // I had a method for calling the Crafatar API to get player faces but it just returns PNG's when given
    // Minecraft UUID's so it's easier to just implement it in the Model
}
