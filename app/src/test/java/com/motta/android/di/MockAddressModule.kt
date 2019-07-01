package com.motta.android.di

import com.motta.android.interactors.AddressInteractor
import com.motta.android.presenters.AddressPresenter
import com.motta.android.repositories.AddressRepository

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import io.mockk.mockk

@Module
class MockAddressModule {

    @Provides
    @Singleton
    fun providesPresenter(): AddressPresenter {
        return mockk(relaxed = true)
    }

    @Provides
    fun providesAddressRepository(): AddressRepository {
        return mockk(relaxed = true)
    }

    @Provides
    @Singleton
    fun providesAddressInteractor(): AddressInteractor {
        return mockk(relaxed = true)
    }
}
