package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.ItemLayoutBinding
import kotlinx.android.synthetic.main.item_layout.view.*


class ShoeListFragment : Fragment() {
    private val viewModel : ListViewModel by activityViewModels()
    lateinit var binding : FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_shoe_list, container, false)
        binding.addItemButton.setOnClickListener{view : View ->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        setHasOptionsMenu(true)
        updateList()
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
    fun updateList(){
for( i in 0 until viewModel.shoes.size){
    var layout : LinearLayout = View.inflate(context!!, R.layout.item_layout, null) as LinearLayout
    layout.newName.text = "Name: " + viewModel.shoes.get(i).name
    layout.newSize.text = "Size: " + viewModel.shoes.get(i).size
    layout.newCompany.text = "Company: " + viewModel.shoes.get(i).company
    layout.newDescription.text = "Description: " + viewModel.shoes.get(i).description
    binding.parentLayout.addView(layout)
    Log.i("ShoeListFragment",viewModel.shoes.get(i).name )
}

    }
}


