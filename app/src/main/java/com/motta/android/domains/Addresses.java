package com.motta.android.domains;

import java.util.Collections;
import java.util.List;

import static com.motta.android.collectors.AddressCollector.toAddresses;

public class Addresses {
    private final List<Address> addressList;

    public Addresses(List<Address> addressList) {
        this.addressList = addressList;
    }

    public static Addresses empty() {
        return new Addresses(Collections.emptyList());
    }

    public Addresses withoutNullAddresses() {
        return addressList.stream()
                .filter(address -> address.getLogradouro() != null)
                .collect(toAddresses());
    }

    public List<Address> toList() {
        return this.addressList;
    }

}
