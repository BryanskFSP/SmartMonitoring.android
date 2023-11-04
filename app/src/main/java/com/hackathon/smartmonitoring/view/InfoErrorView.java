package com.hackathon.smartmonitoring.view;

import com.hackathon.smartmonitoring.network.response.LogsResponse;

public interface InfoErrorView {
    void errorMessage(String msg);
    void showInfo(LogsResponse log);
}
