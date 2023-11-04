package com.hackathon.smartmonitoring.network;

import com.hackathon.smartmonitoring.util.SharedPref;

public class Const {

    public static final String HEAD_URL = "https://newestsm.kaboom.pro/api/";
    public static final String LOGS = "log";
    public static final String KILL_DB = "log/"+ SharedPref.getKillId();
    public static final String WEB_SOCKET ="https://newestsm.kaboom.pro/jubs/logs";

    public static final String FULL_LOG_WITH_INFO = "Log/full";

    public static final String AUTH = "Auth/user";

}
