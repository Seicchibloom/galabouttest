package com.example.galabouttest.ui.account

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {


    // Functions for saving profile data and avatar URI
    fun saveProfileData(context: Context, username: String, name: String, title: String, birthdate: String, residency: String) {
        // Get SharedPreferences instance
        val sharedPreferences = context.getSharedPreferences("ProfileData", Context.MODE_PRIVATE)
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

    fun saveAvatarUriToSharedPreferences(context: Context, imageUri: Uri?) {
        // Get SharedPreferences instance
        val sharedPreferences = context.getSharedPreferences("ProfileData", Context.MODE_PRIVATE)
        // Get SharedPreferences editor
        val editor = sharedPreferences.edit()
        // Store avatar URI
        editor.putString("AVATAR_URI", imageUri.toString())
        // Apply changes
        editor.apply()
    }
}
