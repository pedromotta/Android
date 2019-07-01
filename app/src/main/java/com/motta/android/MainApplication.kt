package com.motta.android

import android.app.Application
import io.realm.Realm

open class MainApplication : Application() {

//    companion object {
//        lateinit var component: ApplicationComponent
//    }

    override fun onCreate() {
        super.onCreate()
//
//        component = DaggerApplicationComponent
//            .factory()
//            .create(applicationContext)

        Realm.init(this)
    }
}
