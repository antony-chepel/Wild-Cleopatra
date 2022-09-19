package com.pnixga.wildcleowhite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import com.pnixga.databinding.ActivitySpinCleoGameBinding
import kotlin.random.Random

class SpinCleoGame : AppCompatActivity() {
    private lateinit var binding: ActivitySpinCleoGameBinding
    private var pqwkqwqwe: CountDownTimer? = null
    private var jnsdfsdf = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinCleoGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bCleoSpin.setOnClickListener {
            if (jnsdfsdf == false) {
                initGame()
            }
        }
        binding.imOut.setOnClickListener {
            finish()
        }
    }


    private fun initGame() = with(binding) {
        pqwkqwqwe?.cancel()
        var spin = Random.nextInt(20) + 10
        spin = spin * 36
        pqwkqwqwe = object : CountDownTimer((spin * 20).toLong(), 1) {
            override fun onTick(millisUntilFinished: Long) {
                jnsdfsdf = true
                bCleoSpin.alpha = 0.7f
                val rotation = imWheel.rotation + 2
                imWheel.rotation = rotation
            }

            override fun onFinish() {
                jnsdfsdf = false
                binding.tvScore.text = "Your score : 1000"
                Handler().postDelayed({
                    val name = intent.getStringExtra("name")
                    bCleoSpin.alpha = 1.0f
                    startActivity(Intent(this@SpinCleoGame,ResultActivityCleo::class.java)
                        .putExtra("gname",name)
                    )
                }, 1000)

            }

        }.start()
        binding.tvScore.text = "Your score : 300"
    }

    override fun onDestroy() {
        super.onDestroy()
        pqwkqwqwe?.cancel()
    }
}