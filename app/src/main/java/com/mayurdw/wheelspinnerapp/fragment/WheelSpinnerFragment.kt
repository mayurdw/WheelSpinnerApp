package com.mayurdw.wheelspinnerapp.fragment

import WheelSpinnerFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.mayurdw.wheelspinnerapp.R
import com.mayurdw.wheelspinnerapp.databinding.WheelSpinnerFragmentBinding
import com.mayurdw.wheelspinnerapp.viewmodels.WheelSpinnerViewModel
import rubikstudio.library.LuckyWheelView

class WheelSpinnerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: WheelSpinnerFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.wheel_spinner_fragment, container, false
        )

        val scoreFragmentArgs by navArgs<WheelSpinnerFragmentArgs>()
        val wheelSpinnerViewModel = ViewModelProvider( this,
            WheelSpinnerFactory( scoreFragmentArgs.itemLists.toList() ) )
            .get( WheelSpinnerViewModel :: class.java)

        binding.lifecycleOwner = this
        binding.viewModel = wheelSpinnerViewModel
        val luckyWheelView: LuckyWheelView = binding.luckyWheel

        wheelSpinnerViewModel.liveSpinIndex.observe( viewLifecycleOwner, {
            if( it >= 0 ){
                luckyWheelView.startLuckyWheelWithTargetIndex( it )
                wheelSpinnerViewModel.doneSpinning()
            }
        })

        return binding.root
    }
}