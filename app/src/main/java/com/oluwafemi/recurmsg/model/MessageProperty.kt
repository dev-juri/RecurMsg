package com.oluwafemi.recurmsg.model

data class MessageProperty (
    val id : Int,
    val messageBody : String,
    val recipient : String,
    val dateAndTime : String,
    val totalSendTime : Int,
    val totalSuccessfullySent : Int
) {
    val status = "$totalSuccessfullySent of $totalSendTime sent."
}