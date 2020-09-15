package com.oluwafemi.recurmsg.model

data class MessageProperty (
    val id : Int,
    val messageBody : String,
    val recipient : String,
    val dateSent : Long,
    val timeSent : Long,
    val totalSendTime : Int,
    val totalSuccessfullySent : Int
) {
    val status = "$totalSuccessfullySent of $totalSendTime sent."
    val dateAndTime = "$timeSent, $dateSent"
}