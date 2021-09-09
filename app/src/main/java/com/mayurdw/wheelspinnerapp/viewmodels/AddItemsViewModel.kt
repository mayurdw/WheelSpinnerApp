package com.mayurdw.wheelspinnerapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddItemsViewModel : ViewModel() {
    private val navigateButtonClicked = MutableLiveData<Boolean>()
    val _navigateButtonClicked : LiveData<Boolean>
        get() = navigateButtonClicked

    val editText = MutableLiveData<String>()

    fun navigateToSpin() {
        navigateButtonClicked.value = true
    }

    fun doneNavigation() {
        navigateButtonClicked.value = false
    }
}