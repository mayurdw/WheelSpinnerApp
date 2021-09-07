package com.mayurdw.wheelspinnerapp.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mayurdw.wheelspinnerapp.R
import com.mayurdw.wheelspinnerapp.viewmodels.AddItemsViewModel

class AddItemsFragment : Fragment() {

    companion object {
        fun newInstance() = AddItemsFragment()
    }

    private lateinit var viewModel: AddItemsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_items_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddItemsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}