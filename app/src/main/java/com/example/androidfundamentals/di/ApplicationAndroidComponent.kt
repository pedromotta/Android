package com.example.androidfundamentals.di

import android.content.Context
import com.example.androidfundamentals.MainAndroidApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, ApplicationActivitiesModule::class])
interface ApplicationAndroidComponent: AndroidInjector<MainAndroidApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationAndroidComponent
    }
}
