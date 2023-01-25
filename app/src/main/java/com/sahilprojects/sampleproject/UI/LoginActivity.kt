package com.sahilprojects.sampleproject.UI

 import android.content.Intent
 import android.os.Bundle
 import android.view.View
 import androidx.appcompat.app.AppCompatActivity
 import com.sahilprojects.sampleproject.R
 import com.sahilprojects.sampleproject.UI.DashBoard.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



    }



    fun register(view : View)
    {
        val intent = Intent(applicationContext, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun login(view : View)
    {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}