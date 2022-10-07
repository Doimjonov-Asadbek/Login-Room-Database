package com.example.logindb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val sharedPreFence = getSharedPreferences("MyReg", Context.MODE_PRIVATE)
        val txtPass = sharedPreFence.getString("password","")

        if (txtPass == ""){
            val intent = Intent(this, LoginFragment::class.java)
            startActivity(intent)
            finish()
        }else{
            val intent = Intent(this, PasswordPage::class.java)
            startActivity(intent)
            finish()
        }
    }
}