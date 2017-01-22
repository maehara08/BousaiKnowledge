package com.riku.land.cs.bousaiknowledge

import android.app.Activity
import android.support.annotation.IdRes
import android.support.multidex.MultiDexApplication
import android.view.View
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.google.firebase.FirebaseApp

/**
 * Created by riku_maehara on 17/01/21.
 */

public class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        FacebookSdk.sdkInitialize(applicationContext)
        FirebaseApp.initializeApp(applicationContext)
        AppEventsLogger.activateApp(this)

    }

    fun <T : View> Activity.findView(@IdRes resId: Int): T = this.findViewById(resId) as T
}