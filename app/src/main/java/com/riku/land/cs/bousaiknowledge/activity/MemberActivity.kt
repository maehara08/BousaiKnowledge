package com.riku.land.cs.bousaiknowledge.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.riku.land.cs.bousaiknowledge.R

class MemberActivity : AppCompatActivity() {
    val TAG = "MemberActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member)
//        val intent =Intent(this, AppTourActivity::class.java)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

//        val faceBookButton = findViewById(R.id.facebookButton) as LoginButton
////        val googleButton = rootView.findViewById(R.id.googlePlusButton) as Button
//
//        val mCallbackManager = com.facebook.CallbackManager.Factory.create()
//        faceBookButton.registerCallback(mCallbackManager, object : FacebookCallback<LoginResult> {
//            override fun onSuccess(loginResult: LoginResult) {
//                Log.d(TAG, "facebook:onSuccess:" + loginResult)
////                handleFacebookAccessToken(loginResult.getAccessToken())
//            }
//
//            override fun onCancel() {
//                Log.d(TAG, "facebook:onCancel")
//                // ...
//            }
//
//            override fun onError(error: FacebookException) {
//                Log.d(TAG, "facebook:onError", error)
//                // ...
//            }
//        })
    }
}
