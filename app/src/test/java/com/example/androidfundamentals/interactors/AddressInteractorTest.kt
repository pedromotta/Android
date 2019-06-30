package com.example.androidfundamentals.interactors

import com.example.androidfundamentals.domains.Address
import com.example.androidfundamentals.remotes.AddressRemote
import com.example.androidfundamentals.repositories.AddressRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class AddressInteractorTest {

    @MockK(relaxed = true)
    lateinit var addressRemote: AddressRemote

    @MockK(relaxed = true)
    lateinit var addressRepository: AddressRepository

    private lateinit var addressInteractor: AddressInteractor

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        addressInteractor = AddressInteractor(addressRemote, addressRepository)
    }

    @Test
    fun saveAddressWhenGetAddressWithSuccess() {
        val address = Address("31030030", "bla", "asda", "asdsa", "BH", "MG")

        every { addressRemote.getAddressByCep("31030030") } returns address

        addressInteractor.searchAddress("31030030")
            .test()
            .assertNoErrors()
            .assertOf {
                verify {
                    addressRepository.saveAddress(address)
                }
            }
            .assertComplete()
    }

    @Test
    fun onErrorWhenGetAddressThrowException() {
        val runtimeException = RuntimeException("Error db")

        every { addressRemote.getAddressByCep("31030030") } throws runtimeException

        addressInteractor.searchAddress("31030030")
            .test()
            .assertError(runtimeException)
            .assertNotComplete()
    }
}