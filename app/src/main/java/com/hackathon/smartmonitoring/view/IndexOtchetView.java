package com.hackathon.smartmonitoring.view;

import com.hackathon.smartmonitoring.network.response.DataIndex;
import com.hackathon.smartmonitoring.network.response.DataIndexOld;

import java.util.List;

public interface IndexOtchetView {
    void getIndexSimple(List<DataIndex> data);
    void getIndexOld(List<DataIndexOld> data);
    void errorMessage(String msg);
}
