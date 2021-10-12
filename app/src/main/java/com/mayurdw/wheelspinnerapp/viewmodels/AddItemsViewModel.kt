package com.mayurdw.wheelspinnerapp.viewmodels

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.mayurdw.wheelspinnerapp.adapter.AddItemAdapter
import com.mayurdw.wheelspinnerapp.adapter.Item

class AddItemsViewModel : ViewModel() {
    private val itemsList = MutableLiveData<List<Item>>()
    val liveItemsList : LiveData<List<Item>>
        get() = itemsList
    private val navigateButtonClicked = MutableLiveData<Boolean>()
    val liveNavigateButtonClicked: LiveData<Boolean>
        get() = navigateButtonClicked

    init {
        itemsList.value = mutableListOf( Item(), Item() )
    }

    fun navigateToSpin() {
        navigateButtonClicked.value = true
    }

    fun doneNavigation() {
        navigateButtonClicked.value = false
    }
}

@BindingAdapter("itemViewModels")
fun bindItemViewModels(recyclerView: RecyclerView, itemViewModels: List<Item>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(itemViewModels)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): AddItemAdapter {
    return recyclerView.adapter as AddItemAdapter
}