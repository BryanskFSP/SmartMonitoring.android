package com.hackathon.smartmonitoring.ui.recycler.models

data class LogDataBase(
    val id: String,
    val time: String,
    val date: String,
    val statusText: String,
    val logType: String,
    val isFixStatus: Boolean,
    val action: String
)
