package com.example.androidfundamentals;

import com.example.androidfundamentals.di.AddressComponent;
import com.example.androidfundamentals.di.DaggerAddressComponent;
import com.example.androidfundamentals.di.MockAddressModule;

public class MainTestApplication extends MainApplication {
    @Override
    public void onCreate() {
        //super.onCreate();
    }

    @Override
    protected AddressComponent getComponent() {
        return null;
//                Mok.builder()
//                .addressModule(new MockAddressModule())
//                .build();
    }
}
