package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListViewModel: ViewModel() {

    val shoes : MutableList<Shoe> = mutableListOf(Shoe("Sneakers","38","Nike","Awesome"))
    fun updateShoeList(shoe : Shoe)
    {
        if (shoe != null) {
            shoes.add(shoe)
            Log.i("ListViewModel", "List updated")
        }
        else Log.i("ListViewModel", "Null is passed")
    }


}