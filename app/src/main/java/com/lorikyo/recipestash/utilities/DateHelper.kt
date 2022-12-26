package com.lorikyo.recipestash.utilities

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId
import java.util.*

val formatter = SimpleDateFormat()

fun getCurrentMilliseconds(): Long {
    return System.currentTimeMillis()
}

fun convertMillisecondsToDateString(milliseconds: Long): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = milliseconds
    return formatter.format(calendar.time)
}

fun isBeforeToday(milliseconds: Long): Boolean {
    val localDateTime = LocalDateTime.now()
    val startOfDay = localDateTime.with(LocalTime.MIN)
    val zoneId = ZoneId.systemDefault()
    val zonedDateTime = startOfDay.atZone(zoneId)
    val millisAtStartOfToday = zonedDateTime.toInstant().toEpochMilli()

    return milliseconds < millisAtStartOfToday
}

