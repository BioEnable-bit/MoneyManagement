package com.sahilprojects.sampleproject.apps

import android.content.Context
import android.content.SharedPreferences
 import com.sahilprojects.sampleproject.contracts.Preferences
import com.sahilprojects.sampleproject.R

class AppPreferences(val context:Context) : Preferences {


    private var prefs : SharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_sync_data),Context.MODE_PRIVATE)

    private val UUID = "uuid"
    private val FIXEDAMOUNT = "fixed_amount"

    override fun putUUID(uuid: String) {
      prefs.edit().putString(UUID,uuid).commit()
    }

    override fun getUUID(): String {
        return prefs.getString(UUID,null)?:""
    }

    override fun putFixedAmout(fixedAmount: String) {
        prefs.edit().putString(FIXEDAMOUNT,fixedAmount).commit()
    }

    override fun getFixedAmout(): String {
        return prefs.getString(FIXEDAMOUNT,null)?:""
    }


}
