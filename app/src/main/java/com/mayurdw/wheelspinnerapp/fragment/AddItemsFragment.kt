package com.mayurdw.wheelspinnerapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayurdw.wheelspinnerapp.R
import com.mayurdw.wheelspinnerapp.adapter.AddItemAdapter
import com.mayurdw.wheelspinnerapp.databinding.AddItemsFragmentBinding
import com.mayurdw.wheelspinnerapp.viewmodels.AddItemsViewModel

class AddItemsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: AddItemsViewModel by lazy { ViewModelProvider( this ).get( AddItemsViewModel::class.java ) }
        val binding : AddItemsFragmentBinding =
            DataBindingUtil.inflate( inflater, R.layout.add_items_fragment, container, false )

        binding.lifecycleOwner = this
        binding.addItemsViewModel = viewModel
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@AddItemsFragment.context)
            adapter = AddItemAdapter()
        }

        viewModel.liveNavigateButtonClicked.observe( viewLifecycleOwner, {
            if( it ){
                val action = AddItemsFragmentDirections.
                actionAddItemsFragmentToWheelSpinnerFragment(
                    viewModel.getItemList()
                )

                view?.findNavController()?.navigate( action )
                viewModel.doneNavigation()
            }
        })

        viewModel.liveAddItemClicked.observe( viewLifecycleOwner, {
            if( it == true ) {
                // Since we know that the only change could be by adding new data
                binding.recyclerView.adapter!!.notifyItemChanged(
                    viewModel.liveItemsList.value!!.size - 1
                )
                viewModel.itemAdded()
            }
        })

        return binding.root
    }

}