package com.example.androidfundamentals

import com.example.androidfundamentals.di.DaggerMockApplciationAndroidComponent

class MainTestApplication : MainAndroidApplication() {

    override fun onCreate() {
        DaggerMockApplciationAndroidComponent
            .factory()
            .create(applicationContext)
            .inject(this)
    }
}
