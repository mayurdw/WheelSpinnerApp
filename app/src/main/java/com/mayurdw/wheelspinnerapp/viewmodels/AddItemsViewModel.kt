package com.mayurdw.wheelspinnerapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddItemsViewModel : ViewModel() {
    private val navigateButtonClicked = MutableLiveData<Boolean>()
    val liveNavigateButtonClicked: LiveData<Boolean>
        get() = navigateButtonClicked
    private val enableSendButton = MutableLiveData(false)
    val liveEnableSendButton: LiveData<Boolean>
        get() = enableSendButton

    val editText = MutableLiveData<String>()

    fun navigateToSpin() {
        if (liveEnableSendButton.value == true) {
            navigateButtonClicked.value = true
        }
    }

    fun doneNavigation() {
        navigateButtonClicked.value = false
    }

    fun textEntered(s: CharSequence, start: Int, before: Int, count: Int) {
        Log.d( "AddItemsViewModel", "args = $s, $start, $before, $count")
        enableSendButton.value = (s.isNotEmpty())
    }

}