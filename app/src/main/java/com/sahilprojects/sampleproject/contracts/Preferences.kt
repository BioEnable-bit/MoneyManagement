package com.sahilprojects.sampleproject.contracts


interface Preferences {

    fun putUUID(uuid: String)
    fun getUUID(): String

    fun putDevidedStatus(status: Boolean)
    fun getDevidedStatus(): Boolean

    fun putFixedAmout(fixedAmount: String)
    fun getFixedAmout(): String

    fun putExtraAmout1(extraAmount1: String)
    fun getExtraAmout1(): String

    fun putExtraAmout2(extraAmount2: String)
    fun getExtraAmout2(): String







}