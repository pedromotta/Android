package com.example.androidfundamentals;

import android.app.Application;

import com.example.androidfundamentals.di.AddressComponent;
import com.example.androidfundamentals.di.AddressModule;
import com.example.androidfundamentals.di.DaggerAddressComponent;

import io.realm.Realm;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }

    protected AddressComponent getComponent() {
        return DaggerAddressComponent.builder()
                .addressModule(new AddressModule())
                .build();
    }

    public AddressComponent buildComponent() {
        return getComponent();
    }
}
