package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {
 private val viewModel : ListViewModel by activityViewModels()
    private val myshoe: Shoe = Shoe("Nike", "34", "Nike", "Awesome")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater ,R.layout.fragment_shoe_detail, container, false)
    binding.myshoe = myshoe

        binding.apply {
            myshoe?.name = nameEdit.text.toString()
            myshoe?.size = sizeEdit.text.toString()
            myshoe?.company = companyEdit.text.toString()
            myshoe?.description = discriptionEdit.text.toString()
        }
        binding.saveButton.setOnClickListener { view: View ->
            viewModel.updateShoeList(Shoe(binding.myshoe!!.name, binding.myshoe!!.size, binding.myshoe!!.company, binding.myshoe!!.description))
        view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())}
        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }


        return binding.root
    }

}


