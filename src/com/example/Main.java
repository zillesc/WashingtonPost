package com.example;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Created by zilles on 9/19/17.
 */
public class Main {
    public static void main(String [] arguments) {
        String url = "https://newsapi.org/v1/articles?source=the-washington-post&sortBy=top&apiKey=" +
                NewsApi.API_KEY;

        // Make an HTTP request to the above URL
        try {
            makeApiRequest(url);
        } catch (UnirestException e) {
//            e.printStackTrace();
            System.out.println("I hate you...");
        }
    }

    private static void makeApiRequest(String url) throws UnirestException {
        final HttpResponse<String> stringHttpResponse;

        stringHttpResponse = Unirest.get(url).asString();
        // Check to see if the request was successful; if so, convert the payload JSON into Java objects
        if (stringHttpResponse.getStatus() == 200) {
            String json = stringHttpResponse.getBody();
            Gson gson = new Gson();
            final NewsCollection newsCollection = gson.fromJson(json, NewsCollection.class);
        }
    }
}
