package com.hackathon.smartmonitoring;
import android.support.multidex.MultiDexApplication;

public class ApplicationLoader extends MultiDexApplication {
    public static ApplicationLoader instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static ApplicationLoader getInstance() {
        return instance;
    }

}