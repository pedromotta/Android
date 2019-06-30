package com.example.androidfundamentals.presenters

import com.example.androidfundamentals.activities.AddressActivity
import com.example.androidfundamentals.domains.Address
import com.example.androidfundamentals.interactors.AddressInteractor
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class AddressPresenterTest {

    @MockK(relaxed = true)
    lateinit var addressActivityMock: AddressActivity

    @MockK(relaxed = true)
    lateinit var addressInteractorMock: AddressInteractor

    private lateinit var addressPresenter: AddressPresenter

    companion object {
        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        }
    }

    @Before
    fun setUp() {
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        MockKAnnotations.init(this)
        addressPresenter = AddressPresenter(addressActivityMock, addressInteractorMock)
    }

    @Test
    fun getAddressByCepFromInteractorAndUpdateAddressInView() {
        val address = Address("31030030", "bla", "asda", "asdsa", "BH", "MG")
        val successInteractorResponse = Observable.just(address)

        every { addressInteractorMock.searchAddress(eq("31030030")) } returns successInteractorResponse

        addressPresenter.searchAddress("31030030")

        verify {
            addressInteractorMock.searchAddress("31030030")
            addressActivityMock.updateAddressData(address)
        }
        verify(exactly = 0) {
            addressActivityMock.showAddressNotFoundMessage()
        }
    }

    @Test
    fun errorWhenTryGetAddressByCepFromInteractorThanShowMessageNotFound() {
        val errorInteractorResponse = Observable.error<Address>(Error())

        every { addressInteractorMock.searchAddress("31030030") } returns errorInteractorResponse

        addressPresenter.searchAddress("31030030")

        verify {
            addressInteractorMock.searchAddress(eq("31030030"))
            addressActivityMock.showAddressNotFoundMessage()
        }
        verify(exactly = 0) {
            addressActivityMock.updateAddressData(any())
        }
    }
}