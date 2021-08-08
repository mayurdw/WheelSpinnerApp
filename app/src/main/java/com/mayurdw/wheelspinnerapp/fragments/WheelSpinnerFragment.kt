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

class WheelSpinnerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: WheelSpinnerFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.wheel_spinner_fragment, container, false
        )

        val scoreFragmentArgs by navArgs<WheelSpinnerFragmentArgs>()

        binding.wheelView.titles = scoreFragmentArgs.args.toList()

        return binding.root
    }
}