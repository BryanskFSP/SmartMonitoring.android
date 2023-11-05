package com.hackathon.smartmonitoring.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OtchetIndexResponse {

    @SerializedName("status") boolean status;
    @SerializedName("name") String name;
    @SerializedName("data") List<DataIndex> dataIndex;

    public OtchetIndexResponse(boolean status, String name, List<DataIndex> dataIndex) {
        this.status = status;
        this.name = name;
        this.dataIndex = dataIndex;
    }

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

    public List<DataIndex> getDataIndex() {
        return dataIndex;
    }

    public void setDataIndex(List<DataIndex> dataIndex) {
        this.dataIndex = dataIndex;
    }
}
