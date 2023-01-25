package com.sahilprojects.sampleproject.model;


 import androidx.lifecycle.LiveData;
 import androidx.room.Dao;
 import androidx.room.Insert;
 import androidx.room.OnConflictStrategy;
 import androidx.room.Query;

 import java.util.List;

@Dao
public interface HeadDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(Heads heads);

  @Query("select Count(*) from heads")
  int getCount();

    @Query("select * from heads")
    LiveData<List<Heads>> getAllHeads();


}
