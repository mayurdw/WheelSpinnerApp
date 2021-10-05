package com.mayurdw.wheelspinnerapp.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mayurdw.wheelspinnerapp.R
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.matcher.ViewMatchers.withId


@RunWith(AndroidJUnit4::class)
class AddItemsFragmentTest{

    @Test
    fun testAddingItems() {
        val scenario = launchFragmentInContainer<AddItemsFragment>(
            initialState = Lifecycle.State.INITIALIZED,
            themeResId = R.style.Theme_WheelSpinnerApp
        )

        scenario.moveToState(Lifecycle.State.RESUMED)
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
}