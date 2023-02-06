package com.sahilprojects.sampleproject.apps

import android.content.Context
import android.content.SharedPreferences
 import com.sahilprojects.sampleproject.contracts.Preferences
import com.sahilprojects.sampleproject.R

class AppPreferences(val context:Context) : Preferences {


    private var prefs : SharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_sync_data),Context.MODE_PRIVATE)

    private val UUID = "uuid"
    private val FIXEDAMOUNT = "fixed_amount"
    private val EXTRAAMOUNT1 = "extra_amount1"
    private val EXTRAAMOUNT2 = "extra_amount2"
    private val DEVIDEDVALUE = "devided_value"

    override fun putUUID(uuid: String) {
      prefs.edit().putString(UUID,uuid).commit()
    }

    override fun getUUID(): String {
        return prefs.getString(UUID,null)?:""
    }

    override fun putDevidedStatus(status: Boolean) {
        prefs.edit().putBoolean(DEVIDEDVALUE,status).commit()
    }

    override fun getDevidedStatus(): Boolean {
        return prefs.getBoolean(DEVIDEDVALUE,false)
    }

    override fun putFixedAmout(fixedAmount: String) {
        prefs.edit().putString(FIXEDAMOUNT,fixedAmount).commit()
    }

    override fun getFixedAmout(): String {
        return prefs.getString(FIXEDAMOUNT,null)?:"0"
    }

    override fun putExtraAmout1(extraAmount1: String) {
        prefs.edit().putString(EXTRAAMOUNT1,extraAmount1).commit()

    }

    override fun getExtraAmout1(): String {
        return prefs.getString(EXTRAAMOUNT1,null)?:""

    }

    override fun putExtraAmout2(extraAmount2: String) {
        prefs.edit().putString(EXTRAAMOUNT2,extraAmount2).commit()

    }

    override fun getExtraAmout2(): String {
        return prefs.getString(EXTRAAMOUNT2,null)?:""

    }


}
