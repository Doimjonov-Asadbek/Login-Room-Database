package com.example.logindb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.logindb.database.DetailsRepository
import com.example.logindb.database.LoginDatabase
import com.example.logindb.databinding.FragmentHomeBinding
import com.example.logindb.viewmodel.LoginModelFactory
import com.example.logindb.viewmodel.LoginViewModel

class HomeFragment : AppCompatActivity() {

    private lateinit var binding:FragmentHomeBinding

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.fragment_home)

        val sharedPreFences = getSharedPreferences("MyReg", MODE_PRIVATE)
        val txtPas = sharedPreFences.getString("password","")
        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            if (txtPas == ""){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PasswordPage::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, LoginFragment::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}