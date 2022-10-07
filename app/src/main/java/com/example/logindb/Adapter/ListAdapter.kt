package com.example.logindb.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.logindb.database.Details
import com.example.logindb.databinding.ListViewBinding

class ListAdapter(private val details:List<Details?>):RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding:ListViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val view=LayoutInflater.from(parent.context)
        val binding=ListViewBinding.inflate(view,parent,false)
        return MyViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            txt1.text="ENTRIES "+details[position]!!.id
            txt2.text="NAME:"+details[position]!!.name
            txt3.text="EMAIL:"+details[position]!!.email
            txt4.text="PHONE NO:"+details[position]!!.phone
        }
    }

    override fun getItemCount(): Int {
        return details.size
    }
}