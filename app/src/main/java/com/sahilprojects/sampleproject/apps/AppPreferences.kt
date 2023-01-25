package com.sahilprojects.sampleproject.apps

import android.content.Context
import android.content.SharedPreferences
 import com.sahilprojects.sampleproject.contracts.Preferences
import com.sahilprojects.sampleproject.R

class AppPreferences(val context:Context) : Preferences {


    private var prefs : SharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_sync_data),Context.MODE_PRIVATE)

    private val UUID = "uuid"

    override fun putUUID(uuid: String) {
      prefs.edit().putString(UUID,uuid).commit()
    }

    override fun getUUID(): String {
        return prefs.getString(UUID,null)?:""
    }

}
