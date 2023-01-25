package com.sahilprojects.sampleproject.model;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;


@Database(entities = {Log.class,Heads.class},exportSchema = false,version = 1)
//@TypeConverters({Database.Converter.class})
public abstract class Db extends RoomDatabase {

    private static final String TAG = Db.class.getSimpleName();
    private static volatile Db INSTANCE;

    public static Db getInstance(Context context){
        if(INSTANCE==null){
            synchronized (Db.class){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), Db.class, "money_management_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    public abstract LogDao logDao();
    public abstract HeadDao headDao();


 }
