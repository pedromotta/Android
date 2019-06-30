package com.example.androidfundamentals.domains

import org.junit.Assert.assertEquals
import org.junit.Test

class AddressTest {

    @Test
    fun shouldReturnAddressText() {
        val address = Address("31030030", "Rua Córrego da Mata", "de 213/214 ao fim", "Horto", "Belo Horizonte", "MG")

        val addressAsText = address.toText()

        assertEquals("Rua Córrego da Mata, de 213/214 ao fim - Horto, Belo Horizonte - MG", addressAsText)
    }
}