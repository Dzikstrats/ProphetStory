package com.example.prophetstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.prophetstory.databinding.ActivityDetailBinding
import com.example.prophetstory.databinding.ActivityDetailRasulBinding
import com.example.prophetstory.model.ResponseNabiItem

class DetailRasulActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailRasulBinding

    companion object {
        const val DATA = "R"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRasulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<ResponseNabiItem>(DATA)

        binding.txtNamarasuldetail.text = data?.nama
        binding.txtDetailusiarasul.text = data?.usia
        binding.txtDetailtempatlahirrasul.text = data?.tempat
        binding.txtDeskdetailrasul.text = data?.deskripsi
        binding.imgRasuldetail.load(data?.avatar)
    }
}
