package com.motta.android.interactors;

import com.motta.android.domains.Address;
import com.motta.android.domains.Addresses;
import com.motta.android.remotes.AddressRemote;
import com.motta.android.repositories.AddressRepository;

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
