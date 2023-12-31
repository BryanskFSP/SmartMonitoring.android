package com.hackathon.smartmonitoring.network.response

import com.google.gson.annotations.SerializedName

data class StatusForCheckingResponse(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("nane")
    val nane: String,
    @SerializedName("data")
    val data: String
)
