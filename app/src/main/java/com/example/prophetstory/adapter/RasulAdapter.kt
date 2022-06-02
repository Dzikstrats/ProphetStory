package com.example.prophetstory.adapter


import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.example.prophetstory.DetailActivity
import com.example.prophetstory.DetailRasulActivity
import com.example.prophetstory.databinding.ItemRecyclerrasulBinding
import com.example.prophetstory.model.ResponseNabiItem

class RasulAdapter(private val listDataRasul : ArrayList<ResponseNabiItem> = arrayListOf()) : RecyclerView.Adapter<RasulAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun addDataRasul(getData: List<ResponseNabiItem>) {
        listDataRasul.clear()
        listDataRasul.addAll(getData)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemRecyclerrasulBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itembinding = ItemRecyclerrasulBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itembinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rasul = listDataRasul[position]
        holder.binding.txtNamarasul.text = rasul.nama
        holder.binding.txtUsiarasul.text = rasul.usia
        holder.binding.txtTempatrasul.text = rasul.tempat
        holder.binding.imgRasul.load(rasul.avatar!!) {
            scale(Scale.FILL)

            holder.itemView.setOnClickListener {
                val intent = Intent(it.context, DetailRasulActivity::class.java)
                intent.putExtra(DetailRasulActivity.DATA, rasul)
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount() = listDataRasul.size


}

