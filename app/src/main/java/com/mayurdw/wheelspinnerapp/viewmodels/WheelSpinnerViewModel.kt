package com.mayurdw.wheelspinnerapp.viewmodels

import android.content.Context
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayurdw.wheelspinnerapp.R
import rubikstudio.library.LuckyWheelView
import rubikstudio.library.model.LuckyItem
import java.util.*

class WheelSpinnerViewModel ( itemList: List<String>, context: Context ): ViewModel() {
    private val luckyItemList = MutableLiveData<List<LuckyItem>>()
    val liveLuckyItemList: LiveData<List<LuckyItem>>
        get() = luckyItemList
    private val spinIndex = MutableLiveData<Int>()
    val liveSpinIndex : LiveData<Int>
        get() = spinIndex
    private val colors = arrayOf(R.color.pink_200, R.color.pink_500)

    init {
        val listItems = mutableListOf<LuckyItem>()

        for (i in itemList.indices) run {
            val luckyItem = LuckyItem()
            luckyItem.secondaryText = itemList[i]
            luckyItem.topText = ( i + 1 ).toString()
            luckyItem.color = context.getColor( this.colors[if (i % 2 == 0) 0 else 1] )
            listItems.add(luckyItem)
        }

        this.luckyItemList.value = listItems
    }

    fun spinWheel() {
        val rand = Random()
        spinIndex.value = rand.nextInt(this.luckyItemList.value!!.size - 1) + 0
    }

    fun doneSpinning(){
        spinIndex.value = -1
    }

}

@BindingAdapter("listViewModel")
fun bindListViewModels( luckyWheelView: LuckyWheelView, listLuckyItem: List<LuckyItem> ){
    luckyWheelView.setData( listLuckyItem )
}
