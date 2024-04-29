package com.example.galabouttest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var createButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)

        usernameEditText = findViewById(R.id.editTextTextPersonUsername)
        passwordEditText = findViewById(R.id.editTextTextPersonPassword2)
        confirmPasswordEditText = findViewById(R.id.editTextTextPersonConfirmPassword)
        emailEditText = findViewById(R.id.editTextTextPersonEmail2)
        createButton = findViewById(R.id.buttonCreateAccount)

        createButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()
            val email = emailEditText.text.toString()

            if (isValidUsername(username) && isValidPassword(password) && password == confirmPassword && isValidEmail(email)) {
                // Successfully created account
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                finish() // Finish current activity and go back to MainActivity
            } else {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidUsername(username: String): Boolean {
        return username.matches("[a-zA-Z0-9]+".toRegex())
    }

    private fun isValidEmail(email: String): Boolean {
        return email.endsWith("@gmail.com") || email.endsWith("gsfe.tupcavite.edu.ph")
    }

    private fun isValidPassword(password: String): Boolean {
        return password.matches("[a-zA-Z0-9]+".toRegex())
    }
}
