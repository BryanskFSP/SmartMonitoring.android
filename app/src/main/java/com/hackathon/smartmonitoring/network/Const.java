package com.hackathon.smartmonitoring.network;

import com.hackathon.smartmonitoring.util.SharedPref;

public class Const {

    public static final String HEAD_URL = "https://sm.kaboom.pro/api/";
    public static final String LOGS = "log";
    public static final String KILL_DB = "log/"+ SharedPref.getKillId();
}
