package com.mayurdw.wheelspinnerapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import com.mayurdw.wheelspinnerapp.R
import com.mayurdw.wheelspinnerapp.databinding.AddItemsFragmentBinding
import com.mayurdw.wheelspinnerapp.viewmodels.AddItemsViewModel

class AddItemsFragment : Fragment() {

    private val viewModel: AddItemsViewModel by lazy { ViewModelProvider( this ).get( AddItemsViewModel::class.java ) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding : AddItemsFragmentBinding =
            DataBindingUtil.inflate( inflater, R.layout.add_items_fragment, container, false )

        binding.lifecycleOwner = this
        binding.addItemsViewModel = viewModel

        viewModel._navigateButtonClicked.observe( viewLifecycleOwner, {
            if( it ){
                val action = AddItemsFragmentDirections.actionAddItemsFragmentToWheelSpinnerFragment()
                view?.findNavController()?.navigate( action )
                viewModel.doneNavigation()
            }
        })

        return binding.root
    }

}