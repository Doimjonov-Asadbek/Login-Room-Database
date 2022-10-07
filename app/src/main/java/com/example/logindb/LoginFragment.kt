package com.example.logindb


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.logindb.Adapter.ListAdapter
import com.example.logindb.database.DetailsRepository
import com.example.logindb.database.LoginDatabase
import com.example.logindb.databinding.FragmentLoginBinding
import com.example.logindb.viewmodel.*

class LoginFragment:Fragment(){
    private lateinit var binding:FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentLoginBinding.inflate(inflater,container,false)
        val dao=LoginDatabase.getInstance(this.activity!!).loginDetailDao()
        val repository=DetailsRepository(dao)
        val factory=UserModelFactory(repository)

        val viewmodel=ViewModelProvider(this,factory)[UserViewModel::class.java]

        binding.lifecycleOwner=this.viewLifecycleOwner
        viewmodel.data.observe(this.viewLifecycleOwner){
            recycleView()
            binding.recycle1.adapter=ListAdapter(it)
        }

        return binding.root
    }
    private fun recycleView(){
        binding.recycle1.hasFixedSize()
        binding.recycle1.layoutManager=LinearLayoutManager(this.context)
    }
}