package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var email: String
    private lateinit var password: String

    companion object {
        val EMAIL = "mmk@gmail.com"
        val PASSWORD = "12345678"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            email = edtEmail.text.toString()
            password = edtPass.text.toString()
            if (email == EMAIL && password == PASSWORD) {
                goToDetailActivity()
            } else {
                Toast.makeText(this, "Login Fail", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun goToDetailActivity() {
        startActivity(DetailActivity.newIntent(this))
        finish()
    }
}
