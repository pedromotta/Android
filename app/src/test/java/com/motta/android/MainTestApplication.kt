package com.motta.android

import com.motta.android.di.DaggerMockApplciationAndroidComponent

class MainTestApplication : MainAndroidApplication() {

    override fun onCreate() {
        component = DaggerMockApplciationAndroidComponent
            .factory()
            .create(applicationContext)

        component.inject(this)
    }
}
