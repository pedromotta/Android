package com.motta.android.activities

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.motta.android.MainAndroidApplication
import com.motta.android.MainTestApplication
import com.motta.android.di.DaggerMockApplciationAndroidComponent
import com.motta.android.presenters.AddressPresenter
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