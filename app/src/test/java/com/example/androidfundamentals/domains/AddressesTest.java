package com.example.androidfundamentals.domains;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class AddressesTest {

    @Test
    public void returnAddressesWithoutNullAddresses() {
        Address validAddress = new Address("31030030", "Rua bla", "Casa", "Horto", "BH", "MG");
        Address nullAddress = new Address("invalid", null, null, null, null, null);

        Addresses addresses = new Addresses(asList(validAddress, nullAddress)).withoutNullAddresses();

        List<Address> addressList = addresses.toList();

        assertEquals(1, addressList.size());
        assertEquals("31030030", addressList.get(0).getCep());
    }

    @Test
    public void returnAnEmptyAddresses() {
        Addresses addressList = Addresses.empty();

        assertEquals(0, addressList.toList().size());
    }
}