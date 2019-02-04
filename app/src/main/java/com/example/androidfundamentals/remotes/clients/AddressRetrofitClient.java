package com.example.androidfundamentals.remotes.clients;

import android.os.AsyncTask;

import com.example.androidfundamentals.remotes.clients.responses.CepResponse;
import com.example.androidfundamentals.remotes.clients.responses.CepResponseNull;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class AddressRetrofitClient  {

    protected CepResponse doInBackground(String ceps) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AddressRetrofit addressAdapter = retrofit.create(AddressRetrofit.class);

        try {
            CepResponse body = addressAdapter.getAddress(ceps).execute().body();
            if (body != null) {
                return body;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new CepResponseNull();
    }

    private interface AddressRetrofit {
        @GET("ws/{cep}/json")
        Call<CepResponse> getAddress(@Path("cep") String cep);
    }
}

