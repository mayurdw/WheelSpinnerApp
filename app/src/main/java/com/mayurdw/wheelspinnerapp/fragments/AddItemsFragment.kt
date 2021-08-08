package com.mayurdw.wheelspinnerapp.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mayurdw.wheelspinnerapp.R
import com.mayurdw.wheelspinnerapp.databinding.AddItemsFragmentBinding
import com.mayurdw.wheelspinnerapp.viewmodels.AddItemsViewModel

class AddItemsFragment : Fragment() {

    private lateinit var viewModel: AddItemsViewModel
    private lateinit var binding: AddItemsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.add_items_fragment, container, false)
        viewModel = AddItemsViewModel()

        binding.doneButton.setOnClickListener {
            view: View ->
                view.findNavController().navigate(R.id.action_addItemsFragment_to_wheelSpinnerFragment)
        }

        return binding.root
    }

}