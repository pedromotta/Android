package com.example.androidfundamentals.di;

import android.app.Application;
import android.content.Context;

import com.example.androidfundamentals.activities.AddressActivity;
import com.example.androidfundamentals.activities.AddressActivityTest;

import dagger.Component;

@Component(modules = {MockAddressModule.class})
public interface MockAddressComponent {
    void inject(AddressActivityTest activityTest);
}
