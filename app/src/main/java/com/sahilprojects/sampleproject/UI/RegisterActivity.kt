package com.sahilprojects.sampleproject.UI

 import android.content.Intent
 import android.os.Bundle
 import android.view.View
 import androidx.appcompat.app.AppCompatActivity
 import com.sahilprojects.sampleproject.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }


    fun signUp(view : View)
    {
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
    }

}