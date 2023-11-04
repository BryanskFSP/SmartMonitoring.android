package com.hackathon.smartmonitoring.network.response

import com.google.gson.annotations.SerializedName

data class FixResponse(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("name")
    val nane: String,
    @SerializedName("data")
    val data: String
)
