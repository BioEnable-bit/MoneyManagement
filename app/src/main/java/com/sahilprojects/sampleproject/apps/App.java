package com.sahilprojects.sampleproject.apps;

import android.app.Application;
import android.provider.ContactsContract;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;

import com.sahilprojects.sampleproject.contracts.Preferences;
import com.sahilprojects.sampleproject.model.Db;
import com.sahilprojects.sampleproject.model.Heads;
import com.sahilprojects.sampleproject.network.WebService;
import com.sahilprojects.sampleproject.network.WebServiceImpl;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class App extends Application implements IApp {

    private static final String TAG = App.class.getSimpleName();
     private WebService webService;
    private Db db;
    private IApp app;
    private Preferences appPreferences;




    @Override
    public void onCreate() {
        super.onCreate();
        app = ((IApp)getApplicationContext());


    }


    @NotNull
    @Override
    public WebService webService() {
        if(webService==null)webService = new WebServiceImpl();
        return webService;
    }



    @NonNull
    @Override
    public Db db() {
        if(db==null)db = Db.getInstance(this);
        return db;
    }

    @NonNull
    @Override
    public Preferences preference() {
        if(appPreferences==null) appPreferences = new AppPreferences(this);
        return appPreferences;
    }
}
