package com.example.nasacollection.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String.TodayDate(): String{
    val dateMilis = Date()
    val datenow = SimpleDateFormat("EEE, MMM d, yyyy", Locale.US).format(dateMilis)
    return datenow.toString()
}

