package com.hackathon.smartmonitoring.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OtchetIndexOldResponse {
    @SerializedName("status") boolean status;
    @SerializedName("name") String name;
    @SerializedName("data") List<DataIndexOld> dataIndexOld;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataIndexOld> getDataIndexOld() {
        return dataIndexOld;
    }

    public void setDataIndexOld(List<DataIndexOld> dataIndexOld) {
        this.dataIndexOld = dataIndexOld;
    }

    public OtchetIndexOldResponse(boolean status, String name, List<DataIndexOld> dataIndexOld) {
        this.status = status;
        this.name = name;
        this.dataIndexOld = dataIndexOld;
    }
}
