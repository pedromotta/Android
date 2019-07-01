package com.motta.android.di

import com.motta.android.activities.AddressActivity

//@Singleton
//@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    //@Component.Factory
    interface Factory {
        //fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun inject(application: AddressActivity)
}
