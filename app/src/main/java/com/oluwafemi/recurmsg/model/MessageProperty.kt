package com.oluwafemi.recurmsg.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Messages")
data class MessageProperty (
    @PrimaryKey
    val id : Int,
    val messageBody : String,
    val recipient : String,
    val dateAndTime : String,
    val totalSendTime : Int,
    val totalSuccessfullySent : Int
) {
    val status = "$totalSuccessfullySent of $totalSendTime sent."
}