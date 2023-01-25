package com.sahilprojects.sampleproject.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "logs")
public class Log {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name="uid")
    private String uid;

    @ColumnInfo (name = "ts")
    private long ts;

    @ColumnInfo(name="lat")
    private double lat;

    @ColumnInfo(name = "lng")
    private double lng;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "status")
    private String status;

    public Log(@NonNull String uid, long ts,  double lat, double lng, String type,String status) {
        this.uid = uid;
        this.ts = ts;
         this.lat = lat;
        this.lng = lng;
        this.type = type;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
