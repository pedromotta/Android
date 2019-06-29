package com.example.androidfundamentals

import android.app.Activity
import android.app.Application
import com.example.androidfundamentals.di.DaggerApplicationAndroidComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import javax.inject.Inject

open class MainAndroidApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationAndroidComponent
            .factory()
            .create(applicationContext)
            .inject(this)

        Realm.init(this)
    }
}
