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
        val intent =Intent(this, AppTourActivity::class.java)
//        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
