package example.codeclan.veggiecompanion;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import example.codeclan.com.veggiecompanion.R;
import example.codeclan.com.veggiecompanion.RestaurantMainActivity;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.core.Is.is;

/**
 * Created by user on 22/03/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest

public class RestaurantActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<RestaurantMainActivity> activityTestRule =
            new ActivityTestRule<>(RestaurantMainActivity.class);

    @Test
    public void checkHeaderIsCorrect(){
        onView(withText("Veggie Companion")).check(matches(isDisplayed()));
    }

    @Test
    public void checkForGoogleMaps(){
        withTagKey(R.string.google_map).matches(onView(withId(R.id.map_fragment)));
    }

    @Test
    public void checkListViewWIthFirstEntry(){
        onView(withId(R.id.restaurant_list));
    }

    @Test
    public void checkForMenu(){
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(withText("Home"));
    }

    @Test
    public void checkForMenuToFavourites(){
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        onView(withText("Favourites"));
    }

    @Test
    public void checkForTheListViewData(){
        onData(allOf(is(instanceOf(String.class)), is("Paradise Palms")));
    }
}

