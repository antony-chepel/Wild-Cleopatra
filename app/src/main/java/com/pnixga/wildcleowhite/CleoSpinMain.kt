package com.pnixga.wildcleowhite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pnixga.databinding.ActivityCleoSpinMainBinding

class CleoSpinMain : AppCompatActivity() {
    private lateinit var binding: ActivityCleoSpinMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCleoSpinMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        jdsjjfwe()
    }

    private fun jdsjjfwe() = with(binding){
        bCleoMain.setOnClickListener {
            val nickText = edCleoNick.text.toString()

            if(nickText.isEmpty() || nickText.length<3){
                tvError.visibility = View.VISIBLE
            } else {
                startActivity(
                    Intent(this@CleoSpinMain, SpinCleoGame::class.java)
                        .putExtra("name",nickText)
                )
                tvError.visibility = View.GONE
                edCleoNick.text.clear()
                edCleoNick.clearFocus()

            }

        }
    }
}