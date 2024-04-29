package com.example.galabouttest.ui.account
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.galabouttest.R

class AccountFragment : Fragment() {

    private lateinit var accountViewModel: AccountViewModel
    private lateinit var editTextUsername: EditText
    private lateinit var editTextName: EditText
    private lateinit var editTextTitle: EditText
    private lateinit var editTextBirthdate: EditText
    private lateinit var editTextResidency: EditText
    private lateinit var buttonEditAvatar: Button
    private lateinit var imageViewEditAvatar: ImageView

    private val picImage = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        accountViewModel = ViewModelProvider(this).get(AccountViewModel::class.java)

        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.updateprofile, container, false)

        // Initialize views
        editTextUsername = rootView.findViewById(R.id.editTextTextPersonName)
        editTextName = rootView.findViewById(R.id.editTextTextPersonName2)
        editTextTitle = rootView.findViewById(R.id.editTextTextPersonName3)
        editTextBirthdate = rootView.findViewById(R.id.editTextTextPersonName4)
        buttonEditAvatar = rootView.findViewById(R.id.button12)

        // Set click listener for edit avatar button
        buttonEditAvatar.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, picImage)
        }

        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == picImage) {
            val imageUri = data?.data
            imageViewEditAvatar.setImageURI(imageUri)

            // Save selected image URI to SharedPreferences using AccountViewModel
            accountViewModel.saveAvatarUriToSharedPreferences(requireContext(), imageUri)
        }
    }
}
