package com.oluwafemi.recurmsg

import java.util.*

fun dateAndTime(): String? {
    val calInstance = Calendar.getInstance()
    val time = calInstance.time
    return time.toString()
}