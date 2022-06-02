package com.example.prophetstory.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.prophetstory.R
import com.example.prophetstory.adapter.NabiAdapter
import com.example.prophetstory.adapter.RasulAdapter
import com.example.prophetstory.databinding.FragmentNabiBinding
import com.example.prophetstory.databinding.FragmentRasulBinding
import com.example.prophetstory.databinding.ItemRecyclerrasulBinding
import com.example.prophetstory.model.ResponseNabiItem
import com.example.prophetstory.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RasulFragment : Fragment() {

    private lateinit var binding: FragmentRasulBinding
    val rasulAdapter = RasulAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRasulBinding.inflate(inflater, container, false)
        with(binding) {
            recyclerrasul.setHasFixedSize(true)
            recyclerrasul.adapter = rasulAdapter
            recyclerrasul.layoutManager = GridLayoutManager(context,2)
        }
        val call = RetrofitService.getService().getDataRasul()
        call.enqueue(object : Callback<List<ResponseNabiItem>>{
            override fun onResponse(
                call: Call<List<ResponseNabiItem>>,
                response: Response<List<ResponseNabiItem>>
            ) {
                val listData = response.body()!!
                listData.let { it.let { it1 -> rasulAdapter.addDataRasul(it1) } }
            }

            override fun onFailure(call: Call<List<ResponseNabiItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return binding.root
    }

}
