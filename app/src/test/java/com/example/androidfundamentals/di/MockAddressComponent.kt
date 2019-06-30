package com.example.androidfundamentals.di

import android.content.Context
import com.example.androidfundamentals.activities.AddressActivityTest
import dagger.BindsInstance

import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, MockAddressModule::class, ApplicationActivitiesModule::class])
@Singleton
interface MockApplciationAndroidComponent: ApplicationAndroidComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationAndroidComponent
    }

    fun inject(addressActivity: AddressActivityTest)
}
