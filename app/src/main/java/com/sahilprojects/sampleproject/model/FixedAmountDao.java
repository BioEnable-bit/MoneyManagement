package com.sahilprojects.sampleproject.model;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FixedAmountDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insert(FixedAmount fixedAmount);

  @Update
  void update(FixedAmount fixedAmount);

  @Query("delete from fixedAmount")
  void delete();


  @Query("select Count(*) from fixedAmount")
  LiveData<Integer> getCount();


  @Query("select * from fixedAmount")
    LiveData<List<FixedAmount>> getFixedAmount();




}
