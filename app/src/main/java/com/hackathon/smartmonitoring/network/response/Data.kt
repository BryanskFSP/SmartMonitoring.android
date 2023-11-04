package com.hackathon.smartmonitoring.network.response

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("entity")
    val entity: String,
    @SerializedName("entityJSON")
    val entityJSON: EntityJSON
)