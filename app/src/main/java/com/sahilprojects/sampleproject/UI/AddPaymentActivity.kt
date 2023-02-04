package com.sahilprojects.sampleproject.UI

 import android.content.Intent
 import android.os.Bundle
 import android.util.Log
 import android.view.Menu
 import android.view.MenuItem
 import android.view.View
 import android.widget.EditText
 import android.widget.Toast
 import androidx.appcompat.app.AppCompatActivity
 import com.sahilprojects.sampleproject.R
 import com.sahilprojects.sampleproject.apps.IApp
 import com.sahilprojects.sampleproject.model.Db
 import com.sahilprojects.sampleproject.model.FixedAmount


class AddPaymentActivity : AppCompatActivity() {


    private lateinit var et_fixed_amount : EditText
    private lateinit var et_Extra_amount1 : EditText
    private lateinit var et_Extra_amount2 : EditText
    private lateinit var app : IApp
    var fixedAmount = "0"
    var extraAmount1 = "0"
    var extraAmount2 = "0"
    var previousAmount = 0
    var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_payment)

       val drawable = resources.getDrawable(R.drawable.grad_splash_screen,theme)
        supportActionBar!!.setBackgroundDrawable(drawable)

        val mActionBar = supportActionBar!!
        mActionBar.title = "Add Payment"
        mActionBar.setDisplayHomeAsUpEnabled(true)

        app = applicationContext as IApp

        et_fixed_amount = findViewById<EditText>(R.id.etFixedAmount);
        et_Extra_amount1 = findViewById<EditText>(R.id.etExtraAmount1);
        et_Extra_amount2 = findViewById<EditText>(R.id.etExtraAmount2);

         Db.getInstance(applicationContext).fixedAmountDao().count.observe(this)
         {
             count1 ->
             if(count1!=0) {
                 Log.e("TAG", "count for fixedamount: $count1")
                 Db.getInstance(this).fixedAmountDao().fixedAmount.observe(this) { fixedAmount1 ->
                     var fa = fixedAmount1 as ArrayList<FixedAmount>
                     previousAmount = fa.get(0).amount
                     Log.e("TAG", "onCreate: $previousAmount")

                 }
             }
         }



    }

    fun submit(view : View)
    {
        fixedAmount = et_fixed_amount.text.toString()
        extraAmount1 = et_Extra_amount1.text.toString()
        extraAmount2 = et_Extra_amount2.text.toString()

        if(fixedAmount.isEmpty())
            fixedAmount = "0"

        if(extraAmount1.isEmpty())
            extraAmount1 = "0"

        if(extraAmount2.isEmpty())
            extraAmount2 = "0"




        var finalAmount = Integer.parseInt(fixedAmount) + Integer.parseInt(extraAmount1) + Integer.parseInt(extraAmount2);



        Log.e("TAG", "previousAmount: $previousAmount")
        Log.e("TAG", "finalAmount: $finalAmount")

       Thread{
           if(previousAmount!=0) {

               var totalAmount = finalAmount + previousAmount;

               Log.e("TAG", "totalAmount: $totalAmount")
               app.db().fixedAmountDao().delete()
               app.db().fixedAmountDao().insert(FixedAmount(totalAmount))
           }
           else {
               Log.e("TAG", "submit: $finalAmount")
               app.db().fixedAmountDao().insert(FixedAmount(finalAmount))

          }


       }.start()
        finish()



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