package com.example.prophetstory.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.prophetstory.DetailActivity
import com.example.prophetstory.databinding.ItemRecyclernabiBinding
import com.example.prophetstory.model.ResponseNabiItem

class NabiAdapter(private val listDataNabi: ArrayList<ResponseNabiItem> = arrayListOf()) :
       RecyclerView.Adapter<NabiAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun addDataNabi(getData: List<ResponseNabiItem>) {
        listDataNabi.clear()
        listDataNabi.addAll(getData)
        notifyDataSetChanged()
    }
    class ViewHolder(var binding : ItemRecyclernabiBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itembinding = ItemRecyclernabiBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(itembinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nabi = listDataNabi[position]
        holder.binding.txtNamanabi.text = nabi.nama
        holder.binding.txtDesknabi.text = nabi.usia
        holder.binding.txtTempatnabi.text = nabi.tempat
        holder.binding.gmbrNabi.load(nabi.avatar!!) {
            scale(Scale.FILL)

            holder.itemView.setOnClickListener {
                val intent = Intent(it.context,DetailActivity::class.java)
                intent.putExtra(DetailActivity.DATA, nabi)
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = listDataNabi.size
    }
