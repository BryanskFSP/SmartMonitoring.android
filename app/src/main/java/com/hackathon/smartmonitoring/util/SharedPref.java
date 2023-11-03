package com.hackathon.smartmonitoring.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.hackathon.smartmonitoring.ApplicationLoader;

public class SharedPref {
    public static final String FILE_NAME = "postre_sql";
    private static SharedPreferences getPrefs() {
        return ApplicationLoader.getInstance().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEdit() {
        return getPrefs().edit();
    }

}
