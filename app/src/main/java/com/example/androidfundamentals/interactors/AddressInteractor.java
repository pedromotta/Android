package com.example.androidfundamentals.interactors;

import com.example.androidfundamentals.domains.Address;
import com.example.androidfundamentals.domains.Addresses;
import com.example.androidfundamentals.remotes.AddressRemote;
import com.example.androidfundamentals.repositories.AddressRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class AddressInteractor {
    public AddressRepository addressRepository;
    public AddressRemote addressRemote;

    @Inject
    public AddressInteractor(final AddressRemote addressRemote, final AddressRepository addressRepository) {
        this.addressRemote = addressRemote;
        this.addressRepository = addressRepository;
    }

    public Observable<Address> searchAddress(String cep) {
        return Observable.create(emitter -> {
            try {
                Address address = addressRemote.getAddressByCep(cep);
                addressRepository.saveAddress(address);
                emitter.onNext(address);
            } catch (Exception e) {
                emitter.onError(e);
            } finally {
                emitter.onComplete();
            }
        });
    }

    public Observable<Addresses> getAddressesNotNull() {
        return Observable.create(emitter -> {
            try {
                Addresses addresses = addressRepository.getAllAddresses();
                emitter.onNext(addresses.withoutNullAddresses());
            } catch (Exception e) {
                emitter.onError(e);
            } finally {
                emitter.onComplete();
            }
        });
    }

}
