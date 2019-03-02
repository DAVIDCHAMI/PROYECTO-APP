package com.example.u12.futbolactivo.views.actividades;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.u12.futbolactivo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() throws InterruptedException {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        ViewInteraction textView = onView(
                allOf(withId(R.id.textViewName), withText("Alaves"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.cardviewItem),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("Alaves")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textViewDescription), withText("Spanish La Liga"),

                        isDisplayed()));
        textView2.check(matches(withText("Spanish La Liga")));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.imageViewProduct),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.cardviewItem),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.imageViewProduct),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.cardviewItem),
                                        0),
                                0),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.reciclerView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.reciclerView),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.txtnombreEquipo), withText("Alaves"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("Alaves")));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.imgEquipo),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction imageView4 = onView(
                allOf(withId(R.id.imaface),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction imageView5 = onView(
                allOf(withId(R.id.imaface),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        imageView5.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }


    /*

     @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void leagueActivityTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction textView = onView(
                allOf(withId(R.id.textViewName), withText("Alaves"),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textViewStadium), withText("Mendizorroza"),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Espresso.onView(ViewMatchers.withId(R.id.recyclerViewTeam))
                .perform(
                        RecyclerViewActions.actionOnItem(
                                hasDescendant(ViewMatchers.withText("Alaves")),
                                ViewActions.scrollTo()
                        )
                );
        Espresso.onView(ViewMatchers.withId(R.id.recyclerViewTeam))
                .perform(
                        RecyclerViewActions.actionOnItem(
                                hasDescendant(ViewMatchers.withText("Alaves")),
                                ViewActions.click()
                        )
                );

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.imageViewBadge),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.textViewName), withText("Alaves-1921"),
                        isDisplayed()));
        textView4.check(matches(isDisplayed()));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.imageViewWebSite),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction imageView4 = onView(
                allOf(withId(R.id.imageViewFacebook),
                        isDisplayed()));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction imageView5 = onView(
                allOf(withId(R.id.imageViewInstagram),
                        isDisplayed()));
        imageView5.check(matches(isDisplayed()));

        ViewInteraction imageView6 = onView(
                allOf(withId(R.id.imageViewTwitter),
                        isDisplayed()));
        imageView6.check(matches(isDisplayed()));

        ViewInteraction imageView7 = onView(
                allOf(withId(R.id.imageViewYoutube),
                        isDisplayed()));
        imageView7.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.textViewDescription), withText("El Deportivo Alavés, S.A.D es un club de fútbol español con sede en la ciudad de Vitoria. Fue fundado en el año 1921 y actualmente juega en la Segunda División de España. Su mayor éxito deportivo tuvo lugar en 2001, cuando, en el año de su debut en competición europea, fue finalista de la Copa de la UEFA ante el Liverpool FC, siendo derrotado por gol de oro (5-4)."),
                        isDisplayed()));
        textView5.check(matches(isDisplayed()));

        pressBack();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Espresso.onView(ViewMatchers.withId(R.id.textViewLeague)).
                check(ViewAssertions.matches(ViewMatchers.withHint("Búsqueda por liga...")));

    }


}
     */
}
