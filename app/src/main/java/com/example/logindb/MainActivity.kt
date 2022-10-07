package com.example.logindb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.logindb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val sharedPreFence = getSharedPreferences("MyReg", MODE_PRIVATE)
        val txtPass = sharedPreFence.getString("password", "")

        if (txtPass == "") {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else {
            val intent = Intent(this, PasswordPage::class.java)
            startActivity(intent)
            finish()
        }
    }

    private lateinit var binding: ActivityMainBinding

}