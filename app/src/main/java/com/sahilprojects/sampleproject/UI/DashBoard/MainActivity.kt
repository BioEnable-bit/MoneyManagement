package com.sahilprojects.sampleproject.UI.DashBoard

 import android.content.Intent
 import android.os.Bundle
 import android.util.Log
 import android.view.Menu
 import android.view.MenuItem
 import android.view.View
 import android.widget.Toast
 import androidx.appcompat.app.AppCompatActivity
 import androidx.lifecycle.Observer
 import androidx.recyclerview.widget.DividerItemDecoration
 import androidx.recyclerview.widget.LinearLayoutManager
 import androidx.recyclerview.widget.RecyclerView
 import com.sahilprojects.sampleproject.R
 import com.sahilprojects.sampleproject.UI.AddPaymentActivity
 import com.sahilprojects.sampleproject.UI.ReportActivity
 import com.sahilprojects.sampleproject.apps.IApp
 import com.sahilprojects.sampleproject.model.Db
 import com.sahilprojects.sampleproject.model.Heads


class MainActivity : AppCompatActivity() {


    lateinit var app : IApp
    lateinit var recyclerView : RecyclerView
    var fixedAmount = 30000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        app = applicationContext as IApp;
        recyclerView = findViewById(R.id.rvHeads)

       val drawable = resources.getDrawable(R.drawable.grad_splash_screen,theme)
        supportActionBar!!.setBackgroundDrawable(drawable)

        val mActionBar = supportActionBar!!
        mActionBar.title = "Dashboard"
        mActionBar.setDisplayHomeAsUpEnabled(true)


        // Progress dialog
//        pDialog = new ProgressDialog(this);
//        pDialog.setTitle("Please wait...");
//        pDialog.setCancelable(false);
        val recyclerLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = recyclerLayoutManager

        val dividerItemDecoration = DividerItemDecoration(
            recyclerView.context,
            recyclerLayoutManager.orientation
        )
        recyclerView.addItemDecoration(dividerItemDecoration)






        Thread {
            Log.e("TAG", "onCreate: "+Db.getInstance(applicationContext).headDao().count )
           if(Db.getInstance(applicationContext).headDao().count!=12)
            for ( i in 1..12) {
                Db.getInstance(applicationContext).headDao()
                    .insert(Heads("Head $i", 10-i, (fixedAmount*10-1)/100, 0, 0))

                

            } }.start()

        Db.getInstance(this).headDao().allHeads.observe(this,
            Observer<List<Any?>?> { heads ->

                var heads1 = heads as ArrayList<Heads?>


                Log.e("TAG", "onCreate: "+heads1.get(2)!!.headTitle )

                   var dashBoardAdapter =DashBoardAdapter(
                        heads as ArrayList<Heads?>,
                        applicationContext
                    )
                    recyclerView.adapter = dashBoardAdapter

            })





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
            val intent = Intent(applicationContext, AddPaymentActivity::class.java)
            startActivity(intent)
            return true
        }
        if (id == R.id.action_reports) {
            val intent = Intent(applicationContext, ReportActivity::class.java)
            startActivity(intent)
            return true
        }
        if (id == androidx.appcompat.R.id.home) {
            Toast.makeText(this, "Item Home", Toast.LENGTH_LONG).show()
            return true
        }


        return super.onOptionsItemSelected(item)

    }
}