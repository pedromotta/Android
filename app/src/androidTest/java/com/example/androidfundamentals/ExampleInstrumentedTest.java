package com.example.androidfundamentals;

import android.content.Context;

import com.example.androidfundamentals.activities.AddressActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ExampleInstrumentedTest {


    @Rule
    public ActivityTestRule<AddressActivity> mActivityRule =
            new ActivityTestRule<>(AddressActivity.class);

    @Test
    public void showErrorWhenSearchButtonAndInternetIsDisabled() {
        onView(withId(R.id.search_cep_button))
                .perform(click());

        onView(withId(android.support.design.R.id.snackbar_text))
                .check(matches(isDisplayed()))
                .check(matches(withText("Endereço não encontrado")));
    }
}
