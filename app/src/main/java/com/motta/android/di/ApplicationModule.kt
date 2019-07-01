package com.motta.android.di

import com.google.gson.Gson

import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun providesGson(): Gson {
        return Gson()
    }
}
