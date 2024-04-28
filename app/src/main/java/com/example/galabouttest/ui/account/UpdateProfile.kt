package com.example.galabouttest.ui.account

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.galabouttest.R

class UpdateProfileActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextName: EditText
    private lateinit var editTextTitle: EditText
    private lateinit var editTextBirthdate: EditText
    private lateinit var editTextResidency: EditText
    private lateinit var buttonSaveChanges: Button
    private lateinit var buttonCancel: Button
    private lateinit var buttonEditAvatar: Button
    private lateinit var imageViewEditAvatar: ImageView

    private val PICK_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.updateprofile)

        // Initialize views

        editTextName = findViewById(R.id.editTextTextPersonName)
        editTextTitle = findViewById(R.id.editTextTextPersonName2)
        editTextBirthdate = findViewById(R.id.editTextTextPersonName3)
        editTextResidency = findViewById(R.id.editTextTextPersonName4)

        buttonEditAvatar = findViewById(R.id.button12)


        // Set click listener for the save button
        buttonSaveChanges.setOnClickListener {
            // Get text from EditText fields
            val username = editTextUsername.text.toString()
            val name = editTextName.text.toString()
            val title = editTextTitle.text.toString()
            val birthdate = editTextBirthdate.text.toString()
            val residency = editTextResidency.text.toString()

            // Save profile data using SharedPreferences
            saveProfileData(username, name, title, birthdate, residency)

            // Finish the activity and return to MainActivity
            finish()
        }

        // Set click listener for the cancel button
        buttonCancel.setOnClickListener {
            // Finish the activity and return to MainActivity without saving changes
            finish()
        }

        // Set click listener for edit avatar button
        buttonEditAvatar.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, PICK_IMAGE)
        }
    }

    private fun saveProfileData(username: String, name: String, title: String, birthdate: String, residency: String) {
        // Get SharedPreferences instance
        val sharedPreferences = getSharedPreferences("ProfileData", Context.MODE_PRIVATE)
        // Get SharedPreferences editor
        val editor = sharedPreferences.edit()
        // Store profile data
        editor.putString("USERNAME", username)
        editor.putString("NAME", name)
        editor.putString("TITLE", title)
        editor.putString("BIRTHDATE", birthdate)
        editor.putString("RESIDENCY", residency)
        // Apply changes
        editor.apply()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE) {
            val imageUri = data?.data
            imageViewEditAvatar.setImageURI(imageUri)

            // Save selected image URI to SharedPreferences
            saveAvatarUriToSharedPreferences(imageUri)
        }
    }

    private fun saveAvatarUriToSharedPreferences(imageUri: Uri?) {
        // Get SharedPreferences instance
        val sharedPreferences = getSharedPreferences("ProfileData", Context.MODE_PRIVATE)
        // Get SharedPreferences editor
        val editor = sharedPreferences.edit()
        // Store avatar URI
        editor.putString("AVATAR_URI", imageUri.toString())
        // Apply changes
        editor.apply()
    }
}
