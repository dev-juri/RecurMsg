package com.oluwafemi.recurmsg.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageProperty (
    @PrimaryKey(autoGenerate = true)
    val id : Int,

    @ColumnInfo(name = "message_body")
    val messageBody : String,

    @ColumnInfo(name = "recipient")
    val recipient : String,

    @ColumnInfo(name = "date_and_time")
    val dateAndTime : String,

    @ColumnInfo(name = "status")
    val status : String
)