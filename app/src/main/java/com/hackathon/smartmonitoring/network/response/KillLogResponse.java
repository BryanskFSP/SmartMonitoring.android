package com.hackathon.smartmonitoring.network.response;

import com.google.gson.annotations.SerializedName;

public class KillLogResponse {
    @SerializedName("Success") boolean success;

    public KillLogResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
