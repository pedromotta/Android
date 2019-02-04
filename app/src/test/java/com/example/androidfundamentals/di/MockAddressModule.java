package com.example.androidfundamentals.di;

import com.example.androidfundamentals.interactors.AddressInteractor;
import com.example.androidfundamentals.presenters.AddressPresenter;
import com.example.androidfundamentals.repositories.AddressRepository;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

@Module
public class MockAddressModule {

    @Provides
    @Singleton
    public AddressPresenter providesPresenter(AddressInteractor addressInteractor) {
        return mock(AddressPresenter.class);
    }

    @Provides
    public Gson providesGson()
    {
        return new Gson();
    }

    @Provides
    public AddressRepository providesAddressRepository()
    {
        return mock(AddressRepository.class);
    }

    @Provides
    public AddressInteractor providesAddressInteractor()
    {
        return mock(AddressInteractor.class);
    }
}
