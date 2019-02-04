package com.example.androidfundamentals.presenters;

import com.example.androidfundamentals.activities.AddressActivity;
import com.example.androidfundamentals.domains.Addresses;
import com.example.androidfundamentals.interactors.AddressInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AddressPresenter {
    private AddressActivity addressActivity;
    private AddressInteractor addressInteractor;

    @Inject
    public AddressPresenter(final AddressInteractor addressInteractor) {
        this.addressInteractor = addressInteractor;
    }

    public void setActivity(AddressActivity addressActivity) {
        this.addressActivity = addressActivity;
    }

    public void searchAddress(String cep) {
        addressInteractor.searchAddress(cep)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.addressActivity::updateAddressData,
                        error -> this.addressActivity.showAddressNotFoundMessage());
    }

    public void refreshAddressList() {
        addressInteractor.getAddressesNotNull()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.addressActivity::refreshAddressList,
                        error -> this.addressActivity.refreshAddressList(Addresses.empty()));
    }
}
