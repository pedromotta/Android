package com.example.androidfundamentals.domains;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    @Test
    public void shouldReturnAddressText() {
        Address address = new Address("31030030","Rua Córrego da Mata", "de 213/214 ao fim", "Horto", "Belo Horizonte", "MG");

        String addressAsText = address.toText();

        assertEquals("Rua Córrego da Mata, de 213/214 ao fim - Horto, Belo Horizonte - MG", addressAsText);
    }
}