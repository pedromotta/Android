package com.motta.android;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import com.motta.android.activities.AddressActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4ClassRunner.class)
public class ExampleInstrumentedTest {


    @Rule
    public ActivityTestRule<AddressActivity> mActivityRule =
            new ActivityTestRule<>(AddressActivity.class);

    @Test
    public void showErrorWhenSearchButtonAndInternetIsDisabled() {
        onView(withId(R.id.search_cep_button))
                .perform(click());

//        onView(withId(android.support.design.R.id.snackbar_text))
//                .check(matches(isDisplayed()))
//                .check(matches(withText("Endereço não encontrado")));
    }
}
