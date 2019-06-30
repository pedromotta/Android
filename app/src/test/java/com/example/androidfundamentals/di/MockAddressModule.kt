package com.example.androidfundamentals.di

import com.example.androidfundamentals.interactors.AddressInteractor
import com.example.androidfundamentals.presenters.AddressPresenter
import com.example.androidfundamentals.repositories.AddressRepository

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
