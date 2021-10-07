package com.mayurdw.wheelspinnerapp.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mayurdw.wheelspinnerapp.R
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before


@RunWith(AndroidJUnit4::class)
class AddItemsFragmentTest{
    private val navController = TestNavHostController(
        ApplicationProvider.getApplicationContext()
    )

    @Before
    fun setup() {
        val scenario = launchFragmentInContainer<AddItemsFragment>(
            initialState = Lifecycle.State.INITIALIZED,
            themeResId = R.style.Theme_WheelSpinnerApp
        )

        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment{
            navController.setGraph( R.navigation.nav_graph )

            Navigation.setViewNavController(
                it.requireView(),
                navController
            )
        }
    }

    @Test
    fun testAddingItems() {
        onView( withId(R.id.recycler_view)).check(
            matches( hasChildCount( 1 ) )
        )

        onView( withId(R.id.add_item_button)).perform(
            ViewActions.click()
        )

        onView( withId(R.id.recycler_view)).check(
            matches( hasChildCount( 2 ) )
        )
    }

    @Test
    fun testNavigation() {


        onView(withId( R.id.sendButton ) )
            .perform(ViewActions.click() )

        assertEquals( navController.currentDestination?.id,
            R.id.wheelSpinnerFragment )
    }

    @Test
    fun testNavigationArgs() {
        // TODO: Implement test here
    }

    @Test
    fun testRemovingItems() {
        // Test removing elements
    }
}