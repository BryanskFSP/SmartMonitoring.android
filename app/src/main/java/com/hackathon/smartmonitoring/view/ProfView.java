package com.hackathon.smartmonitoring.view;

import com.hackathon.smartmonitoring.network.response.LogFullResponse;

public interface ProfView {

    void getLogInfo(LogFullResponse data);
    void errorMessage(String msg);
}
