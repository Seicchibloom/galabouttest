package com.example.galabouttest.ui.accommodations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccommodationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Name of Place"
    }
    val text: LiveData<String> = _text
}