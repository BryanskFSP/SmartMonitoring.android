package com.hackathon.smartmonitoring.network.response

import com.google.gson.annotations.SerializedName

data class EntityJSON(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("organizationID")
    val organizationID: String,
    @SerializedName("login")
    val login: String
)
