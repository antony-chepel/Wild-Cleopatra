package com.pnixga.wildcleoblack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.orhanobut.hawk.Hawk
import com.pnixga.R
import com.pnixga.wildcleoblack.WCLEOCONST.C1
import com.pnixga.wildcleoblack.WCLEOCONST.D1
import com.pnixga.wildcleoblack.WCLEOCONST.DEV
import com.pnixga.wildcleowhite.CleoSpinMain
import kotlinx.android.synthetic.main.activity_filt.*
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class WCleoFilt : AppCompatActivity() {

    lateinit var jsoup: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filt)

        jsoup = ""

        val job = GlobalScope.launch(Dispatchers.IO) {
            jsoup = gststdwqdqwd()
            Log.d("jsoup status from global scope", jsoup)
        }

        runBlocking {
            try {
                job.join()

                Log.d("jsoup status out of global scope", jsoup)
                txtMain.text = jsoup

                if (jsoup == WCLEOCONST.jsoupCheck) {
                    Intent(applicationContext, CleoSpinMain::class.java).also { startActivity(it) }
                } else {
                    Intent(applicationContext, WCleoWeb::class.java).also { startActivity(it) }
                }
                finish()
            } catch (e: Exception) {

            }
        }

    }

    private suspend fun gststdwqdqwd(): String {
        val hawk: String? = Hawk.get(C1, "null")
        val hawkAppLink: String? = Hawk.get(D1, "null")
        val hawkDevOrNot: String? = Hawk.get(DEV, "false")



        val forJsoupSetNaming: String = WCLEOCONST.lru + WCLEOCONST.odone + hawk + "&" + WCLEOCONST.twoSub + hawkDevOrNot
        val forJsoupSetAppLnk: String = WCLEOCONST.lru + WCLEOCONST.odone + hawkAppLink + "&" +  WCLEOCONST.twoSub + hawkDevOrNot

        withContext(Dispatchers.IO) {
            if (hawk != "null") {
                oaspooqweqwe(forJsoupSetNaming)
                Log.d("Check1C", forJsoupSetNaming)
            } else {
                oaspooqweqwe(forJsoupSetAppLnk)
                Log.d("Check1C", forJsoupSetAppLnk)
            }
        }
        return jsoup
    }

    private fun oaspooqweqwe(link: String) {
        val url = URL(link)
        val urlConnection = url.openConnection() as HttpURLConnection

        try {
            val text = urlConnection.inputStream.bufferedReader().readText()
            if (text.isNotEmpty()) {
                Log.d("jsoup status inside Url function", text)
                jsoup = text
            } else {
                Log.d("jsoup status inside Url function", "is null")
            }
        } catch (ex: Exception) {

        } finally {
            urlConnection.disconnect()
        }
    }
}