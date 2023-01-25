package com.sahilprojects.sampleproject.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "heads")
public class Heads {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name="headTitle")
    private String headTitle;

    @ColumnInfo (name = "headPercent")
    private int headPercent;

    @ColumnInfo(name="headAmount")
    private int headAmount;

    @ColumnInfo(name="headUsedAmount")
    private int headUsedAmount;

    @ColumnInfo(name = "headRemainingAmount")
    private int headRemainingAmount;

//    @ColumnInfo(name = "remark")
//    private String remark;


    public Heads( @NonNull String headTitle, int headPercent, int headAmount, int headUsedAmount, int headRemainingAmount) {
        this.headTitle = headTitle;
        this.headPercent = headPercent;
        this.headAmount = headAmount;
        this.headUsedAmount = headUsedAmount;
        this.headRemainingAmount = headRemainingAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getHeadTitle() {
        return headTitle;
    }

    public void setHeadTitle(@NonNull String headTitle) {
        this.headTitle = headTitle;
    }

    public int getHeadPercent() {
        return headPercent;
    }

    public void setHeadPercent(int headPercent) {
        this.headPercent = headPercent;
    }

    public int getHeadAmount() {
        return headAmount;
    }

    public void setHeadAmount(int headAmount) {
        this.headAmount = headAmount;
    }

    public int getHeadUsedAmount() {
        return headUsedAmount;
    }

    public void setHeadUsedAmount(int headUsedAmount) {
        this.headUsedAmount = headUsedAmount;
    }

    public int getHeadRemainingAmount() {
        return headRemainingAmount;
    }

    public void setHeadRemainingAmount(int headRemainingAmount) {
        this.headRemainingAmount = headRemainingAmount;
    }
}
