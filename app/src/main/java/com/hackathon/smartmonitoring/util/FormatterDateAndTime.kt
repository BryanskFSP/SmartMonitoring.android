package com.hackathon.smartmonitoring.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FormatterDateAndTime {
   companion object {
       data class DateAndTime(
           val time: String,
           val date: String
       )
   }

    fun format(date: String): DateAndTime {
        val dateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME)
        val formatterTime = DateTimeFormatter.ofPattern("HH:mm")
        val formatterData = DateTimeFormatter.ofPattern("dd:MM:yy")

        return DateAndTime(
            dateTime.format(formatterTime),
            dateTime.format(formatterData)
        )
    }
}