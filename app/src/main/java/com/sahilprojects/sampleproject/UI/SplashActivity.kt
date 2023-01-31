package com.sahilprojects.sampleproject.UI

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sahilprojects.sampleproject.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)




        var text : TextView = findViewById(R.id.text)
        var pencil : ImageView = findViewById(R.id.pencil)

        text.visibility = View.VISIBLE
        pencil.visibility = View.VISIBLE
        //loading our custom made animations
        val animation = AnimationUtils.loadAnimation(this, R.anim.textview_anomation)
        //starting the animation
        text.startAnimation(animation)
        pencil.startAnimation(animation)


        Handler().postDelayed(Runnable {
         val intent = Intent(applicationContext, LoginActivity::class.java)
          startActivity(intent)
            finish()
        },3000)

    }
}

