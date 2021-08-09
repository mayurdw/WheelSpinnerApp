package com.mayurdw.wheelspinnerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mayurdw.wheelspinnerapp.R
import com.mayurdw.wheelspinnerapp.databinding.AddItemsFragmentBinding

class AddItemsFragment : Fragment() {
    private lateinit var binding: AddItemsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.add_items_fragment, container, false)


        binding.doneButton.setOnClickListener { view: View ->
            val stringArray : Array<String> = this.getInputTexts()

            if( stringArray.size < 2 ){
                Toast.makeText(context, "Invalid Data", Toast.LENGTH_LONG).show()
            } else {
                val action =
                    AddItemsFragmentDirections.actionAddItemsFragmentToWheelSpinnerFragment(
                        this.getInputTexts()
                    )
                view.findNavController().navigate(action)
            }

        }

        return binding.root
    }

    private fun getInputTexts() : Array<String> {
        val inputs = mutableListOf<String>()

        this.addIfNotNull( this.binding.item0.text.toString(), inputs )
        this.addIfNotNull( this.binding.item1.text.toString(), inputs )
        this.addIfNotNull( this.binding.item2.text.toString(), inputs )
        this.addIfNotNull( this.binding.item3.text.toString(), inputs )
        this.addIfNotNull( this.binding.item4.text.toString(), inputs )
        this.addIfNotNull( this.binding.item5.text.toString(), inputs )
        this.addIfNotNull( this.binding.item6.text.toString(), inputs )
        this.addIfNotNull( this.binding.item7.text.toString(), inputs )

        return inputs.toTypedArray()
    }

    private fun addIfNotNull(inputText: String, list: MutableList<String> ) {
        if ( inputText.isNotBlank() ){
            list.add( inputText )
        }
    }

}