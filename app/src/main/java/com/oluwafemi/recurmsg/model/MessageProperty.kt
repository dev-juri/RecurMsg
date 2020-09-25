package com.oluwafemi.recurmsg.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MessageProperty (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val messageBody : String,
    val recipient : String,
    val dateAndTime : String,
    val status : String
)