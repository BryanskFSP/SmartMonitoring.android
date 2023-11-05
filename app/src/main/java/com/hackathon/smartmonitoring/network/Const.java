package com.hackathon.smartmonitoring.network;

import com.hackathon.smartmonitoring.util.SharedPref;

public class Const {

    public static final String HEAD_URL = "https://newestsm.kaboom.pro/api/";
    public static final String LOGS = "log";
    public static final String KILL_DB = "log/"+ SharedPref.getKillId();
    public static final String WEB_SOCKET ="https://newestsm.kaboom.pro/jubs/logs";

    public static final String FULL_LOG_WITH_INFO = "Log/full";

    public static final String AUTH = "Auth/user";


    //todo CHEKING PROBLEMS
    public static final String CHECK_FULL ="DataBase/{id}/check/full"; // проверка всего сразу
    public static final String CHECK_MEMORY = "DataBase/{id}/check/memory"; // проверка память
    public static final String CHECK_STATES = "DataBase/{id}/check/states"; // проверка потоков
    public static final String CHECK_CHAHINGRATIO = "DataBase/{id}/check/cachingratio"; // проверка кэширования
    public static final String CHECK_CHAHINGR_INDEX = "DataBase/{id}/check/cachingindexesratio"; // проверка кэширования индексов

    public static final String FIX_FULL ="DataBase/{id}/fix/full"; //фикс всех ошибок


    public static final String GET_DB_ON_ID = "DataBase"; // get all db

}
