package com.sahilprojects.sampleproject.apps

import com.sahilprojects.sampleproject.contracts.Preferences
 import com.sahilprojects.sampleproject.model.Db
import com.sahilprojects.sampleproject.network.WebService

interface IApp {

    fun webService() : WebService
    fun db() : Db
    fun preference() : Preferences


}