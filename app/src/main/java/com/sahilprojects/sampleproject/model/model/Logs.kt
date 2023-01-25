package com.sahilprojects.sampleproject.model.model

import com.google.gson.annotations.SerializedName

class Logs {

    class Read {
        class Request(
            @SerializedName("fromDate") private val fromDate: String,
            @SerializedName("toDate") private val toDate: String,
            @SerializedName("orgid") private val orgid: String,
            @SerializedName("uuid") private val uuid: String,
        ) {
            @SerializedName("q")
            val q = "attendance_logs"
        }


        class Response {
            @SerializedName("logs")
            lateinit var logs: List<logs>
        }
    }

    class logs{
        @SerializedName("uuid") lateinit var uuid : String
        @SerializedName("empname") lateinit var empname : String
        @SerializedName("PunchDate") lateinit var PunchDate : String
        @SerializedName("PunchTime") lateinit var PunchTime : String
        @SerializedName("latitude") lateinit var latitude : String
        @SerializedName("longitude") lateinit var longitude : String
        @SerializedName("Status") lateinit var Status : String
        @SerializedName("orgid") lateinit var orgid : String
        @SerializedName("intime") lateinit var intime : String
        @SerializedName("outtime") lateinit var outtime : String
        @SerializedName("workinghrs") lateinit var workinghrs : String

    }
}

