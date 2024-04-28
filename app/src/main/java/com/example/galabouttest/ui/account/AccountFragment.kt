package com.example.galabouttest.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.galabouttest.R

class AccountFragment : Fragment() {

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        accountViewModel = ViewModelProvider(this).get(AccountViewModel::class.java)
        val layoutResId = accountViewModel.layoutResId.value ?: R.layout.updateprofile // Provide a default layout if needed

        return inflater.inflate(layoutResId, container, false)
    }

    // Add the provided function here
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Call the provided function
        setupProfileUpdate()
    }

    private fun setupProfileUpdate() {
        // Your code for handling profile update goes here
        // You can call the UpdateProfile functions here or any other logic related to profile update
        // For example:
        // UpdateProfile.updateProfile(requireContext(), "username", "name", "title", "birthdate", "residency")
        // UpdateProfile.updateAvatarUri(requireContext(), imageUri)
    }
}
