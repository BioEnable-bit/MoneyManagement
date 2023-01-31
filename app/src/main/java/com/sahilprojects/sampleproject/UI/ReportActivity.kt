package com.sahilprojects.sampleproject.UI

 import android.app.DatePickerDialog
 import android.app.DatePickerDialog.OnDateSetListener
 import android.app.Dialog
 import android.os.Bundle
 import android.util.Log
 import android.view.Menu
 import android.view.MenuItem
 import android.view.View
 import android.widget.DatePicker
 import android.widget.TextView
 import android.widget.Toast
 import androidx.appcompat.app.AppCompatActivity
 import com.sahilprojects.sampleproject.R
 import java.util.*


class ReportActivity : AppCompatActivity() {

    private val datePicker: DatePicker? = null
    private lateinit var calendar: Calendar
    private val dateView: TextView? = null
    private var year = 0;
    private  var month:kotlin.Int = 0;
    private  var day:kotlin.Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

       val drawable = resources.getDrawable(R.drawable.grad_splash_screen,theme)
        supportActionBar!!.setBackgroundDrawable(drawable)

        val mActionBar = supportActionBar!!
        mActionBar.title = "Reports"
        mActionBar.setDisplayHomeAsUpEnabled(true)

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
       // showDate(111,year, month+1, day);

    }


    private fun showDate(id: Int,year: Int, month: Int, day: Int) {

        if(id==111)
        {
            Log.e("TAG", "From Date:$id "+StringBuilder().append(day).append("/").append(month).append("/").append(year))
        }
        else if (id==112) {
            Log.e("TAG", "To Date:$id " + StringBuilder().append(day).append("/").append(month).append("/").append(year))
        }
    }

    fun setDate1(view: View?) {
        showDialog(111)

    }

    fun setDate2(view: View?) {
        showDialog(112)

    }

    override fun onCreateDialog(id: Int): Dialog?
    {
        return DatePickerDialog(this, myDateListener, year, month, day)
    }

    private val myDateListener =
        OnDateSetListener { arg0, arg1, arg2, arg3 -> // TODO Auto-generated method stub

            Log.e("TAG", ": ${arg0.id}", )
            showDate(arg0.id,arg1, arg2 + 1, arg3)
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