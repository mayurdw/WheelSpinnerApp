package com.mayurdw.wheelspinnerapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mayurdw.wheelspinnerapp.R
import com.mayurdw.wheelspinnerapp.viewmodels.WheelSpinnerViewModel

class WheelSpinnerFragment : Fragment() {

    companion object {
        fun newInstance() = WheelSpinnerFragment()
    }

    private lateinit var viewModel: WheelSpinnerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.wheel_spinner_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WheelSpinnerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}