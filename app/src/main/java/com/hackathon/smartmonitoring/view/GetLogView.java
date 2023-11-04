package com.hackathon.smartmonitoring.view;
import com.hackathon.smartmonitoring.network.response.LogsResponse;

import java.util.List;

public interface GetLogView {
    void errorMessage(String msg);
    void getLogsFromService(List<LogsResponse> data);
}
