package com.example.androidfundamentals.presenters;

import com.example.androidfundamentals.activities.AddressActivity;
import com.example.androidfundamentals.domains.Address;
import com.example.androidfundamentals.interactors.AddressInteractor;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddressPresenterTest {

    private AddressActivity addressActivityMock;
    private AddressInteractor addressInteractorMock;
    private AddressPresenter addressPresenter;

    @Before
    public void setUp() {
        addressActivityMock = mock(AddressActivity.class);
        addressInteractorMock = mock(AddressInteractor.class);
        addressPresenter = new AddressPresenter(addressInteractorMock);
        addressPresenter.setActivity(addressActivityMock);
    }

    @Test
    public void getAddressByCepFromInteractorAndUpdateAddressInView() {
        Address address = new Address("31030030", "bla", "asda", "asdsa", "BH", "MG");
        Observable<Address> successInteractorResponse = Observable.just(address);

        when(addressInteractorMock.searchAddress("31030030")).thenReturn(successInteractorResponse);

        addressPresenter.searchAddress("31030030");

        verify(addressInteractorMock).searchAddress("31030030");
        verify(addressActivityMock, never()).showAddressNotFoundMessage();
        verify(addressActivityMock).updateAddressData(address);
    }

    @Test
    public void errorWhenTryGetAddressByCepFromInteractorThanShowMessageNotFound() {
        Observable<Address> errorInteractorResponse = Observable.error(Error::new);

        when(addressInteractorMock.searchAddress("31030030")).thenReturn(errorInteractorResponse);

        addressPresenter.searchAddress("31030030");

        verify(addressInteractorMock).searchAddress("31030030");
        verify(addressActivityMock).showAddressNotFoundMessage();
        verify(addressActivityMock, never()).updateAddressData(any());
    }
}