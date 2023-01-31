package com.sahilprojects.sampleproject.UI

 import android.os.Bundle
 import android.view.Menu
 import android.view.MenuItem
 import android.widget.Toast
 import androidx.appcompat.app.AppCompatActivity
 import com.sahilprojects.sampleproject.R


class AddPaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_payment)

       val drawable = resources.getDrawable(R.drawable.grad_splash_screen,theme)
        supportActionBar!!.setBackgroundDrawable(drawable)

        val mActionBar = supportActionBar!!
        mActionBar.title = "Add Payment"
        mActionBar.setDisplayHomeAsUpEnabled(true)

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.action_add_payment) {
            Toast.makeText(this, "Item Add Payment", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.action_reports) {
            Toast.makeText(this, "Item Reports", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == androidx.appcompat.R.id.home) {
            Toast.makeText(this, "Item Home", Toast.LENGTH_LONG).show()
            return true
        }


        return super.onOptionsItemSelected(item)

    }
}