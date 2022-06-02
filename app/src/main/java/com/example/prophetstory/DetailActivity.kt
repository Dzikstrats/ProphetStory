package com.example.prophetstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.prophetstory.databinding.ActivityDetailBinding
import com.example.prophetstory.databinding.ActivityMainBinding
import com.example.prophetstory.model.ResponseNabiItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding

    companion object {
        const val DATA = "s"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<ResponseNabiItem>(DATA)

        binding.txtNamadetail.text = data?.nama
        binding.txtDetailusianabi.text = data?.usia
        binding.txtDetailtempatlahir.text = data?.tempat
        binding.txtDeskdetail.text = data?.deskripsi
        binding.imgNabidetail.load(data?.avatar)

    }
}