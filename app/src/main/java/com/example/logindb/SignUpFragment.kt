package com.example.logindb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.logindb.database.DetailsRepository
import com.example.logindb.database.LoginDatabase
import com.example.logindb.databinding.FragmentSignUpBinding
import com.example.logindb.viewmodel.RegisterModelFactory
import com.example.logindb.viewmodel.RegisterViewModel

class SignUpFragment:Fragment() {
    private lateinit var binding:FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSignUpBinding.inflate(inflater,container,false)
        val dao=LoginDatabase.getInstance(this.activity!!).loginDetailDao()
        val repository=DetailsRepository(dao)
        val factory=RegisterModelFactory(repository)
        val viewmodel= ViewModelProvider(this,factory)[RegisterViewModel::class.java]

        binding.view=viewmodel

        binding.lifecycleOwner=this
        viewmodel._errorMail.observe(this.viewLifecycleOwner){
            if(it==true){
                binding.txtfield2.helperText="INVALID MAIL"
                viewmodel.setNavigation()
            }
        }
        viewmodel._numberError.observe(this.viewLifecycleOwner){
            if(it==true){
                binding.textField3.helperText="INVALID NUMBER"
                viewmodel.setNavigation()
            }
        }
        viewmodel._count.observe(this.viewLifecycleOwner){
            if(it==true){
                binding.textpass.helperText="MINIMUM 8 CHARACTERS"
                viewmodel.setNavigation()
            }
        }

        viewmodel._errorMsg.observe(this.viewLifecycleOwner) {
            if (it == true) {
                Toast.makeText(requireContext(), "FILL ALL THE FIELDS", Toast.LENGTH_SHORT).show()
                viewmodel.error()
            }
        }
        viewmodel._passwordError.observe(this.viewLifecycleOwner){
            if (it==true){
                binding.txtfield5.helperText="INCORRECT PASSWORD"
                viewmodel.setNavigation()
            }
        }
        viewmodel._check.observe(this.viewLifecycleOwner){
            if(it==true){
                Toast.makeText(requireContext(),"ACCEPT THE TERMS",Toast.LENGTH_SHORT).show()
                if(binding.check.isChecked) {
                    binding.check.text = "ACCEPTED"
                }
                viewmodel.setNavigation()
            }
        }

        viewmodel._navigation.observe(this.viewLifecycleOwner) { check ->
            if (check == true) {
                navigationView()
                viewmodel.setNavigation()
            }
        }


        return binding.root
    }
    private fun navigationView(){
         val action=SignUpFragmentDirections.actionSignUpFragmentToHomeFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }

}