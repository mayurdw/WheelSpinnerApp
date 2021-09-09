package com.mayurdw.wheelspinnerapp.fragment

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mayurdw.wheelspinnerapp.R

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddItemsFragmentTest {

    @Test
    fun testNonClickableButton() {
        launchFragmentInContainer<AddItemsFragment>()

        onView(withId(R.id.sendButton)).check(matches(isNotClickable()))
    }
}