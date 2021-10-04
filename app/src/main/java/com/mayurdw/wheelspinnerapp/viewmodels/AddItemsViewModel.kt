package com.mayurdw.wheelspinnerapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddItemsViewModel : ViewModel() {
    private val navigateButtonClicked = MutableLiveData<Boolean>()
    val liveNavigateButtonClicked: LiveData<Boolean>
        get() = navigateButtonClicked

    fun navigateToSpin() {
        navigateButtonClicked.value = true
    }

    fun doneNavigation() {
        navigateButtonClicked.value = false
    }

}