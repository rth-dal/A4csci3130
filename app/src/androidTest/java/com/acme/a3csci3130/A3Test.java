package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumentation test, executes on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class A3Test {

    public String name, number, province, address, job;
    public Business business;


    @Rule
    public ActivityTestRule<MainActivity> mainActRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * initializer of business object
     */
    @Before
    public void init() {
        System.out.print("Test Run");

        name = "Anthony";
        number = "123456789";
        province = "BC";
        address = "65 Superior Road";
        job = "Fish Monger";

        business = new Business(null, name, number, province, address, job);
    }

    /**
     * test for db create
     * @throws Exception
     */
    @Test
    public void useAppContext() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText(name));
        onView(withId(R.id.number)).perform(typeText(number));
        onView(withId(R.id.province)).perform(typeText(province));
        onView(withId(R.id.address)).perform(typeText(address));
        onView(withId(R.id.job)).perform(typeText(job));
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.listView)).perform(click());
    }

    /**
     * test for db update
     * @throws Exception
     */
    @Test
    public void updateTest() throws Exception {
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.name)).perform(typeText(name));
        onView(withId(R.id.updateButton)).perform(click());
    }

    /**
     * test for db erase
     * @throws Exception
     */
    @Test
    public void deleteTest() throws Exception {
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
