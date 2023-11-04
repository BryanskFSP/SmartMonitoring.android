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
    public static final String KILL_ID = "kill_id";

    public static final String ID_DATA_BASE ="id_data_base";

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
        return getPrefs().getString(AUTH_TOKEN, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJJRCI6IjA0MzE0OWYwLTRkYzktNGFiMC05YTkwLWRmNmU2NzlmYzY2MiIsIkxvZ2luIjoiYWRtaW4iLCJFbnRpdHkiOiJVc2VyIiwiaHR0cDovL3NjaGVtYXMueG1sc29hcC5vcmcvd3MvMjAwNS8wNS9pZGVudGl0eS9jbGFpbXMvbmFtZWlkZW50aWZpZXIiOiIwNDMxNDlmMC00ZGM5LTRhYjAtOWE5MC1kZjZlNjc5ZmM2NjIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiMDQzMTQ5ZjAtNGRjOS00YWIwLTlhOTAtZGY2ZTY3OWZjNjYyIiwiZXhwIjoxNzMwNjY3OTczLCJpc3MiOiJTTS5TZXJ2ZXIiLCJhdWQiOiJTTS5DbGllbnQifQ.pV4LoQa3442LcJSXsSRHzYRBRCLAL0DGF9-G6Zy7z68");
    }

    public static void setKillId(String id)  {
        getEdit().putString(KILL_ID, id).commit();
    }

    public static String getKillId() {
        return getPrefs().getString(KILL_ID, null);
    }
    public static void setIdDataBase(String id)  {
        getEdit().putString(ID_DATA_BASE, id).commit();
    }

    public static String getIdDataBase() {
        return getPrefs().getString(ID_DATA_BASE, "c3adc5c3-2905-4adc-bdda-ac3fca03a043");
    }


}
