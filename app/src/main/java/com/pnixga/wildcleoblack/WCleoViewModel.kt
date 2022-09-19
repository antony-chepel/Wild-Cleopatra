package com.pnixga.wildcleoblack

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.appsflyer.AppsFlyerConversionListener
import com.facebook.applinks.AppLinkData
import com.orhanobut.hawk.Hawk
import com.pnixga.wildcleoblack.WCLEOCONST.D1
import javax.inject.Inject

class WCleoViewModel @Inject constructor() : ViewModel() {
    val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {

            val dataGotten = data?.get("campaign").toString()
            Hawk.put(WCLEOCONST.C1, dataGotten)
            Log.d("devTEST", data.toString())
        }

        override fun onConversionDataFail(p0: String?) {

        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }


    fun xgfsfafdewqe(context: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val params = appLinkData.targetUri.host

                Log.d("D11PL", "$params")

                Hawk.put(D1, params.toString())


            }
            if (appLinkData == null) {
                Log.d("FB_ERR:", "Params = null")
            }
        }
    }
}