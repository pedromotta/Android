package com.example.androidfundamentals.activities;

import com.example.androidfundamentals.MainTestApplication;
import com.example.androidfundamentals.presenters.AddressPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(application = MainTestApplication.class)
public class AddressActivityTest {

    private AddressPresenter addressPresenter;

    @Before
    public void setUp() {

    }

    @Test
    public void refreshListOnStart() {
        AddressActivity addressActivity = Robolectric.setupActivity(AddressActivity.class);
        addressPresenter = addressActivity.addressPresenter;

        //verify(addressPresenter).setActivity(addressActivity);
        verify(addressPresenter).refreshAddressList();
    }

    @Test
    public void refreshListOnStart2() {
        AddressActivity addressActivity = Robolectric.setupActivity(AddressActivity.class);
        addressPresenter = addressActivity.addressPresenter;

        //verify(addressPresenter).setActivity(addressActivity);
        verify(addressPresenter).refreshAddressList();
    }
}