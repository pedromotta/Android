package com.example.androidfundamentals

import com.example.androidfundamentals.di.DaggerMockApplciationAndroidComponent

class MainTestApplication : MainAndroidApplication() {

    override fun onCreate() {
        component = DaggerMockApplciationAndroidComponent
            .factory()
            .create(applicationContext)

        component.inject(this)
    }
}
