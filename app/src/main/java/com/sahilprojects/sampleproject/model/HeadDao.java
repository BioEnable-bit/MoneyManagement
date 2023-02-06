package com.sahilprojects.sampleproject.model;


 import androidx.lifecycle.LiveData;
 import androidx.room.Dao;
 import androidx.room.Insert;
 import androidx.room.OnConflictStrategy;
 import androidx.room.Query;
 import androidx.room.Update;

 import java.util.List;

@Dao
public interface HeadDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(Heads heads);

  @Query("update heads set headAmount = :headAmount, headUsedAmount = :headUsedAmount, headRemainingAmount =:headRemainingAmount where headTitle = :headTitle")
  void updateHeads (String headTitle,int headAmount, int headUsedAmount,int headRemainingAmount);


  @Query("select Count(*) from heads")
  int getCount();

    @Query("select * from heads")
    LiveData<List<Heads>> getAllHeads();

    @Query("SELECT * FROM heads LIMIT :value,1")
    Heads head(int value);





    @Query("update heads set  headRemainingAmount = :remaingAmount, headUsedAmount = :usedAmount where headTitle =:headTitle")
    void updateExpenseAmount(String headTitle,int usedAmount,int remaingAmount);
}
