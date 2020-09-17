package com.oluwafemi.recurmsg.util

import java.util.*

fun dateAndTime(): String? {
    val calInstance = Calendar.getInstance()
    val time = calInstance.time
    return time.toString()
}