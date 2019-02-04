package com.example.androidfundamentals.di;

import com.example.androidfundamentals.activities.AddressActivity;
import com.example.androidfundamentals.interactors.AddressInteractor;
import com.example.androidfundamentals.presenters.AddressPresenter;
import com.example.androidfundamentals.repositories.AddressRepository;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

@Module
public class AddressModule {

    @Provides
    public AddressPresenter providesPresenter(AddressInteractor addressInteractor) {
        return new AddressPresenter(addressInteractor);
    }

    @Provides
    public Gson providesGson() {
        return new Gson();
    }

    @Provides
    public AddressRepository providesAddressRepository() {
        return new AddressRepository();
    }
}
