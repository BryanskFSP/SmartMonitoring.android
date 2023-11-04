package com.hackathon.smartmonitoring.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FormatterDateAndTime {
   companion object {
       data class DateAndTime(
           val time: String,
           val date: String
       )
   }

    @RequiresApi(Build.VERSION_CODES.O)
    fun format(date: String): DateAndTime {
        val dateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME)
        val formatterTime = DateTimeFormatter.ofPattern("HH:mm:SS")
        val formatterData = DateTimeFormatter.ofPattern("dd.MM.yyyy")

        return DateAndTime(
            dateTime.format(formatterTime),
            dateTime.format(formatterData)
        )
    }
}