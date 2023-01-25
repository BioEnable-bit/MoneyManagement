package com.sahilprojects.sampleproject.UI

import android.content.Intent
 import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sahilprojects.sampleproject.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(Runnable {
         val intent = Intent(applicationContext, LoginActivity::class.java)
          startActivity(intent)
            finish()
        },3000)

    }
}