package com.motta.android.di

import com.motta.android.activities.AddressActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ApplicationActivitiesModule {

    @ContributesAndroidInjector
    abstract fun addressActivity(): AddressActivity
}