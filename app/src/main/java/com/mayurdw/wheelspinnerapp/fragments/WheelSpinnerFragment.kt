package com.mayurdw.wheelspinnerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.mayurdw.wheelspinnerapp.R
import com.mayurdw.wheelspinnerapp.databinding.WheelSpinnerFragmentBinding
import rubikstudio.library.LuckyWheelView
import rubikstudio.library.model.LuckyItem
import java.util.*


class WheelSpinnerFragment : Fragment() {
    private val data = mutableListOf<LuckyItem>()
    private val colors = arrayOf( 0xffFFE0B2.toInt(), 0xffFFCC80.toInt() )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: WheelSpinnerFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.wheel_spinner_fragment, container, false
        )

        val scoreFragmentArgs by navArgs<WheelSpinnerFragmentArgs>()
        val luckyWheelView: LuckyWheelView = binding.luckyWheel

        binding.spinButton.setOnClickListener {
            val index = getRandomIndex()
            luckyWheelView.startLuckyWheelWithTargetIndex(index)
        }

        this.populateListItems( scoreFragmentArgs.args.toList() )
        luckyWheelView.setData( this.data )

        return binding.root
    }

    private fun populateListItems( stringList: List<String> ) {
        for ( i in stringList.indices) run {
            val luckyItem = LuckyItem()
            luckyItem.secondaryText = stringList[i]
            luckyItem.color = this.colors[ if ( i / 2 == 0 ) 0 else 1 ]
            this.data.add(luckyItem)
        }
    }

    private fun getRandomIndex(): Int {
        val rand = Random()
        return rand.nextInt( this.data.size - 1) + 0
    }

    private fun getRandomRound(): Int {
        val rand = Random()
        return rand.nextInt(10) + 15
    }


}