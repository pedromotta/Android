package com.motta.android.repositories;

import android.util.Log;

import com.motta.android.collectors.AddressCollector;
import com.motta.android.converters.AddressConverter;
import com.motta.android.domains.Address;
import com.motta.android.domains.Addresses;
import com.motta.android.repositories.models.AddressModel;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AddressRepository {

    private Realm realmInstance;

    @Inject
    public AddressRepository() {
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);
    }

    public void saveAddress(final Address address) {
        try {
            final AddressModel addressModel = AddressConverter.domainToModel(address);

            realmInstance = Realm.getDefaultInstance();
            realmInstance.beginTransaction();
            realmInstance.copyToRealmOrUpdate(addressModel);
            realmInstance.commitTransaction();

            Log.i(this.getClass().getName(), "Save Address DB success");

        } catch (Exception e) {
            Log.e(this.getClass().getName(), "save DB Error", e);
            throw e;
        } finally {
            realmInstance.close();
        }
    }

    public Addresses getAllAddresses() {
        try {
            realmInstance = Realm.getDefaultInstance();

            Addresses addresses = realmInstance
                    .where(AddressModel.class)
                    .findAll()
                    .stream()
                    .map(AddressConverter::modelToDomain)
                    .collect(AddressCollector.toAddresses());

            Log.i(this.getClass().getName(), "Get All Address DB success");
            return addresses;
        } catch (Exception e) {
            Log.e(this.getClass().getName(), "get DB Error", e);
            throw e;
        } finally {
            realmInstance.close();
        }
    }
}
