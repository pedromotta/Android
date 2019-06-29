package com.example.androidfundamentals.di

import com.example.androidfundamentals.activities.AddressActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ApplicationActivitiesModule {

    @ContributesAndroidInjector
    abstract fun addressActivity(): AddressActivity
}