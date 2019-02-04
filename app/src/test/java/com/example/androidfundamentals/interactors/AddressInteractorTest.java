package com.example.androidfundamentals.interactors;

import com.example.androidfundamentals.domains.Address;
import com.example.androidfundamentals.remotes.AddressRemote;
import com.example.androidfundamentals.repositories.AddressRepository;

import org.junit.Before;
import org.junit.Test;
import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.observers.BaseTestConsumer;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import io.reactivex.subscribers.TestSubscriber;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddressInteractorTest {

    private AddressInteractor addressInteractor;
    private AddressRemote addressRemote;
    private AddressRepository addressRepository;

    @Before
    public void setUp() {
        addressRemote = mock(AddressRemote.class);
        addressRepository = mock(AddressRepository.class);
        addressInteractor = new AddressInteractor(addressRemote, addressRepository);
    }

    @Test
    public void saveAddressWhenGetAddressWithSuccess() {
        Address address = new Address("31030030", "bla", "asda", "asdsa", "BH", "MG");

        when(addressRemote.getAddressByCep("31030030")).thenReturn(address);

        addressInteractor.searchAddress("31030030")
                .test()
                .assertNoErrors()
                .assertOf(a -> verify(addressRepository).saveAddress(address))
                .assertComplete();
    }

    @Test
    public void onErrorWhenGetAddressThrowException() {
        RuntimeException runtimeException = new RuntimeException("Error db");

        when(addressRemote.getAddressByCep("31030030")).thenThrow(runtimeException);

        addressInteractor.searchAddress("31030030")
                .test()
                .assertError(runtimeException)
                .assertNotComplete();
    }
}