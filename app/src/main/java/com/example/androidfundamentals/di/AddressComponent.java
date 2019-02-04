package com.example.androidfundamentals.di;

import android.app.Application;
import android.content.Context;

import com.example.androidfundamentals.activities.AddressActivity;

import dagger.Component;

@Component(modules = {AddressModule.class})
public interface AddressComponent {
    void inject(AddressActivity application);
}
