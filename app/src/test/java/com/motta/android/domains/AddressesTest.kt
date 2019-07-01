package com.motta.android.domains

import org.junit.Assert.assertEquals
import org.junit.Test

internal class AddressesTest {

    @Test
    fun returnAddressesWithoutNullAddresses() {
        val validAddress = Address("31030030", "Rua bla", "Casa", "Horto", "BH", "MG")
        val nullAddress = Address("invalid", null, null, null, null, null)

        val addresses = Addresses(listOf(validAddress, nullAddress)).withoutNullAddresses()

        val addressList = addresses.toList()

        assertEquals(1, addressList.size)
        assertEquals("31030030", addressList[0].cep)
    }

    @Test
    fun returnAnEmptyAddresses() {
        val addressList = Addresses.empty()

        assertEquals(0, addressList.toList().size)
    }
}