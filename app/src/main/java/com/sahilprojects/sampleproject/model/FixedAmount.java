package com.sahilprojects.sampleproject.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "fixedAmount")
public class FixedAmount {



    @PrimaryKey
    @ColumnInfo (name = "amount")
    private int amount;

    public FixedAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
