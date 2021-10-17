package com.mayurdw.wheelspinnerapp.viewmodels

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.mayurdw.wheelspinnerapp.adapter.AddItemAdapter
import com.mayurdw.wheelspinnerapp.adapter.Item

class AddItemsViewModel : ViewModel() {
    private val itemsList = MutableLiveData<MutableList<Item>>()
    val liveItemsList : LiveData<MutableList<Item>>
        get() = itemsList
    private val navigateButtonClicked = MutableLiveData<Boolean>()
    val liveNavigateButtonClicked: LiveData<Boolean>
        get() = navigateButtonClicked
    val listAdapter: AddItemAdapter = AddItemAdapter()

    init {
        itemsList.value = mutableListOf( Item(), Item() )
    }

    fun navigateToSpin() {
        navigateButtonClicked.value = true
    }

    fun doneNavigation() {
        navigateButtonClicked.value = false
    }

    fun addItem() {
        this.itemsList.value!!.add( Item() )
        this.listAdapter.notifyItemChanged( this.itemsList.value!!.size - 1 )
    }

    fun getItemList() : Array<String> {
        return itemsList.value!!.flatMap {
            listOf( it.text )
        }.toTypedArray()
    }
}

@BindingAdapter("itemViewModels")
fun bindItemViewModels(recyclerView: RecyclerView, itemViewModels: List<Item>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(itemViewModels)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): AddItemAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is AddItemAdapter) {
        recyclerView.adapter as AddItemAdapter
    } else {
        val addItemAdapter = AddItemAdapter()
        recyclerView.adapter = addItemAdapter
        addItemAdapter
    }}