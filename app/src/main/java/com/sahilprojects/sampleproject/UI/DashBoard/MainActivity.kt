package com.sahilprojects.sampleproject.UI.DashBoard

 import android.app.Dialog
 import android.content.Intent
 import android.os.Bundle
 import android.util.Log
 import android.view.Menu
 import android.view.MenuItem
 import android.view.Window
 import android.widget.Button
 import android.widget.EditText
 import android.widget.TextView
 import android.widget.Toast
 import androidx.appcompat.app.AlertDialog
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


class MainActivity : AppCompatActivity() , DashBoardAdapter.onDashItemClicked {


    lateinit var app : IApp
    lateinit var recyclerView : RecyclerView
    var fixedAmount = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        app = applicationContext as IApp;
        recyclerView = findViewById(R.id.rvHeads)

       app.preference().putFixedAmout("30000")

        val tv_fixed_Amount : TextView = findViewById(R.id.tvFixedAmount)


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


        val headName = ArrayList<String>()
       headName.add("Family")
       headName.add("EMI")
       headName.add("Education")
       headName.add("Health")
       headName.add("Enjoyment")
       headName.add("Insurance")
       headName.add("Savings")
       headName.add("Donation")
       headName.add("Hotel")
       headName.add("Travelling")
       headName.add("Emergency Fund")
       headName.add("Other")

        val headPercentage = ArrayList<Int>()
        headPercentage.add(30)
        headPercentage.add(30)
        headPercentage.add(5)
        headPercentage.add(5)
        headPercentage.add(5)
        headPercentage.add(2)
        headPercentage.add(7)
        headPercentage.add(1)
        headPercentage.add(3)
        headPercentage.add(5)
        headPercentage.add(5)
        headPercentage.add(2)


        for (i in 0..11)
        {
            Log.e("TAG", "onCreate: "+ headName[i] +" "+ headPercentage[i])
        }


        fixedAmount = Integer.parseInt(app.preference().getFixedAmout())
        tv_fixed_Amount.text = fixedAmount.toString()+" ₹"


        Thread {
            Log.e("TAG", "onCreate: "+Db.getInstance(applicationContext).headDao().count )
           if(Db.getInstance(applicationContext).headDao().count==0)
            for ( i in 0..11) {



                if(fixedAmount.equals(0))
                Db.getInstance(applicationContext).headDao()
                    .insert(Heads(headName[i], headPercentage[i],0,0,0 ))
                else
                {
                    Db.getInstance(applicationContext).headDao()
                        .insert(Heads(headName[i], headPercentage[i],(fixedAmount*headPercentage[i])/100,0,0 ))
                }

            } }.start()

        Db.getInstance(this).headDao().allHeads.observe(this,
            Observer<List<Any?>?> { heads ->
                var heads1 = heads as ArrayList<Heads?>
                   var dashBoardAdapter =DashBoardAdapter(
                        heads as ArrayList<Heads?>,
                        applicationContext,this
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

    override fun onItemClicked(headTitle: String?, headPercentage: Int, headAmount: Int, headUsedAmount: Int, headRemainingAmount: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.add_expense_alert_ayout)
        val title = dialog.findViewById(R.id.tvTitle) as TextView
        val subTitle = dialog.findViewById(R.id.tvSubTitle) as TextView
        val etAddAmount = dialog.findViewById(R.id.etExpenseAmount) as EditText
        title.text = "Add expense for $headTitle"
        subTitle.text = "You can do expense upto $headAmount ₹"


        val yesBtn = dialog.findViewById(R.id.btn_yes) as Button
        val noBtn = dialog.findViewById(R.id.btn_cancel) as Button
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }
        noBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }
}