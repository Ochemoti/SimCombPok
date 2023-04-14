package com.example.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica1.databinding.ActivityHuidaBinding

class huida : AppCompatActivity() {
    lateinit var binding:ActivityHuidaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_huida)
        binding = ActivityHuidaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btvolver.setOnClickListener{volver()}
    }

    private fun volver() {
        onBackPressed()
    }
}