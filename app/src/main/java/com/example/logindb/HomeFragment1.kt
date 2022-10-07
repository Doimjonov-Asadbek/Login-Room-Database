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
import com.example.logindb.databinding.FragmentHomeBinding
import com.example.logindb.viewmodel.LoginModelFactory
import com.example.logindb.viewmodel.LoginViewModel

class HomeFragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var binding = FragmentHomeBinding.inflate(inflater, container, false)
        val dao= LoginDatabase.getInstance(this.requireActivity()).loginDetailDao()
        val repository= DetailsRepository(dao)
        val factory= LoginModelFactory(repository)
        val viewModel= ViewModelProvider(this,factory)[LoginViewModel::class.java]

        binding.homeViewModel=viewModel
        binding.lifecycleOwner=this

        viewModel._navigation.observe(this.viewLifecycleOwner){ check->
            if(check==true){
                login()
                viewModel.setNavigation()
            }
        }
        viewModel._error.observe(this.viewLifecycleOwner){
            if(it==true){
                Toast.makeText(requireContext(),"Fill The Fields", Toast.LENGTH_SHORT).show()
                viewModel.setNavigation()
            }
        }
        viewModel._signupnavigation.observe(this.viewLifecycleOwner){check->
            if(check==true){
                signup()
                viewModel.setSignNavigation()
            }
        }
        viewModel._passwordError.observe(this.viewLifecycleOwner){
            if(it==true){
                Toast.makeText(requireContext(),"EITHER USERNAME OR PASSWORD ERROR", Toast.LENGTH_SHORT).show()
                viewModel.setPassword()
            }
        }
        return binding.root
    }
    private fun login(){
        val action=HomeFragmentDirections.actionHomeFragmentToLoginFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
    private fun signup(){
        val action=HomeFragmentDirections.actionHomeFragmentToSignUpFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}