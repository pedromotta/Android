package com.example.androidfundamentals.remotes.clients;

import android.util.Log;

import com.example.androidfundamentals.remotes.clients.responses.CepResponse;
import com.example.androidfundamentals.remotes.clients.responses.CepResponseNull;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.inject.Inject;

public class AddressClient {

    Gson gson;

    @Inject
    public AddressClient(Gson gson) {
        this.gson = gson;
    }

    public CepResponse get(String cep) {
        try {
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);

            connection.connect();

            StringBuilder response = new StringBuilder();

            Scanner scanner = new Scanner(url.openStream());

            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }

            Log.i(this.getClass().getName(), response.toString());

            return gson.fromJson(response.toString(), CepResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new CepResponseNull();
    }
}
