package com.example.androidfundamentals.activities

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidfundamentals.MainAndroidApplication
import com.example.androidfundamentals.MainTestApplication
import com.example.androidfundamentals.di.DaggerMockApplciationAndroidComponent
import com.example.androidfundamentals.presenters.AddressPresenter
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import javax.inject.Inject

@Config(application = MainTestApplication::class)
@RunWith(AndroidJUnit4::class)
class AddressActivityTest {

    @Inject
    lateinit var addressPresenter: AddressPresenter

    @Before
    fun setUp() {
        (MainAndroidApplication.component as DaggerMockApplciationAndroidComponent).inject(this)
    }

    @Test
    fun refreshListOnStart() {
        val addressActivity = launch(AddressActivity::class.java)

        addressActivity.moveToState(Lifecycle.State.CREATED)

        addressActivity.onActivity {
            verify {
                addressPresenter.refreshAddressList()
            }
        }
    }
}