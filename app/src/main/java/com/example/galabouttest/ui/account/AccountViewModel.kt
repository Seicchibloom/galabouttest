package com.example.galabouttest.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.galabouttest.R // Import your R class

class AccountViewModel : ViewModel() {

    private val _layoutResId = MutableLiveData<Int>().apply {
        value = R.layout.updateprofile // Replace with the actual resource ID of your updateprofile.xml layout file
    }
    val layoutResId: LiveData<Int> = _layoutResId
}
