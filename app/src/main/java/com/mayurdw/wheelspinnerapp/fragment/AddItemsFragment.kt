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
import com.mayurdw.wheelspinnerapp.adapter.Item
import com.mayurdw.wheelspinnerapp.databinding.AddItemsFragmentBinding
import com.mayurdw.wheelspinnerapp.viewmodels.AddItemsViewModel

class AddItemsFragment : Fragment() {

    private var addItemsList : ArrayList<Item> = arrayListOf( Item() )
    private lateinit var listAdapter: AddItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: AddItemsViewModel by lazy { ViewModelProvider( this ).get( AddItemsViewModel::class.java ) }
        val binding : AddItemsFragmentBinding =
            DataBindingUtil.inflate( inflater, R.layout.add_items_fragment, container, false )

        binding.lifecycleOwner = this
        binding.addItemsViewModel = viewModel
        listAdapter = AddItemAdapter(addItemsList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@AddItemsFragment.context)
            adapter = listAdapter
        }

        binding.addItemButton.setOnClickListener {
            addItemsList.add( Item() )
            listAdapter.notifyDataSetChanged()
        }

        viewModel.liveNavigateButtonClicked.observe( viewLifecycleOwner, {
            if( it ){
                val action = AddItemsFragmentDirections.actionAddItemsFragmentToWheelSpinnerFragment()
                view?.findNavController()?.navigate( action )
                viewModel.doneNavigation()
            }
        })

        return binding.root
    }

}