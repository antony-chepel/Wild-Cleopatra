package com.pnixga.wildcleowhite

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pnixga.databinding.ActivityResultCleoBinding

class ResultActivityCleo : AppCompatActivity() {
    private lateinit var binding: ActivityResultCleoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultCleoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dfsfsdf()
    }

    @SuppressLint("SetTextI18n")
    private fun dfsfsdf() = with(binding){
       val name = intent.getStringExtra("gname")
        tvName.text = "$name,congratulations!!!"
        button2.setOnClickListener {
            startActivity(Intent(this@ResultActivityCleo,CleoSpinMain::class.java))
        }
    }
}