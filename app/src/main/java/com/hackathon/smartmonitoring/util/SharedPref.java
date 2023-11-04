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

    public static final String AUTH_USER = "auth_user";
    public static final String AUTH_TOKEN = "auth_token";

    public static void setAuthUser(boolean auth) {
        getEdit().putBoolean(AUTH_USER, auth).commit();
    }
    public static boolean getAuthUser() {
        return getPrefs().getBoolean(AUTH_USER, false);
    }

    public static void setToken(String token)  {
        getEdit().putString(AUTH_TOKEN, token).commit();
    }

    public static String getToken() {
        return getPrefs().getString(AUTH_TOKEN, null);
    }

}
