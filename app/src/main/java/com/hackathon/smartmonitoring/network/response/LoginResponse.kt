package com.hackathon.smartmonitoring.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("data")
    val data: Data,
    @SerializedName("entityHash")
    val entityHash: String,
    @SerializedName("entityID")
    val entityID: String,
    @SerializedName("platformID")
    val platformID: String,
    @SerializedName("token")
    val token: String
)
