package com.pnixga

import android.app.Application
import android.content.Context
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import com.pnixga.wildcleoblack.WCLEOCONST.MAIN_ID
import com.pnixga.wildcleoblack.WCLEOCONST.ONESIGNAL_APP_ID
import com.pnixga.wildcleoblack.WCleoAdv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppCleoClass : Application() {
    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        GlobalScope.launch(Dispatchers.IO) {
            hdydtwqwqe(context = applicationContext)
        }
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }

    private suspend fun hdydtwqwqe(context: Context) {
        val advertisingInfo = WCleoAdv(context)
        val idInfo = advertisingInfo.yststdtqwd()
        Hawk.put(MAIN_ID, idInfo)
    }
}