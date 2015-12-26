package gd.not.testapplication;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.hasToString;

/**
 * Created by stork on 14/12/2015.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testMultipleSpinners() {
        onData(hasToString("Spinner 1 bar")).inAdapterView(withId(R.id.spinner1)).perform(click());
        onData(hasToString("Spinner 2 bar")).inAdapterView(withId(R.id.spinner2)).perform(click());
        onData(hasToString("Spinner 3 bar")).inAdapterView(withId(R.id.spinner3)).perform(click());
    }
}
