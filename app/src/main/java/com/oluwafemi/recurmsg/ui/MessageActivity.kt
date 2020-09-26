package com.oluwafemi.recurmsg.ui

import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.oluwafemi.recurmsg.R
import com.oluwafemi.recurmsg.databinding.ActivityMessageBinding
import com.oluwafemi.recurmsg.model.MessageProperty
import com.oluwafemi.recurmsg.util.dateAndTime
import com.oluwafemi.recurmsg.viewmodel.MessageActivityViewModel

class MessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessageBinding
    private lateinit var recipientNumber: String
    private lateinit var messageBody: String
    private lateinit var recurNumber: String
    private lateinit var status: String
    private lateinit var viewModel: MessageActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message)
        viewModel = ViewModelProvider(this).get(MessageActivityViewModel::class.java)
        binding.viewModel = viewModel

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.sendBtn.setOnClickListener {
            recipientNumber = binding.phoneNumber.editText?.text.toString().trim()
            messageBody = binding.textMessage.editText?.text.toString().trim()
            recurNumber = binding.times.text.toString().trim()

            if (recipientNumber.isNotEmpty() && messageBody.isNotEmpty() && recurNumber.isNotEmpty() && recurNumber.toInt() > 0) {
                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.SEND_SMS
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    sendSMS()
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.SEND_SMS),
                        SMS_REQUEST_CODE
                    )
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "Please fill in all fields, and make sure number of times to send is not 0",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }
    }

    private fun sendSMS() {
        val smsManager = SmsManager.getDefault()
        val sentIntent = Intent(SENT_SMS_FLAG)

        val sentPI = PendingIntent.getBroadcast(this, 0, sentIntent, 0)

        for (i in 1..recurNumber.toInt()) {
            smsManager.sendTextMessage(recipientNumber, null, messageBody, sentPI, null)

            if (i == recurNumber.toInt()) {
                binding.phoneNumber.editText?.setText("")
                binding.textMessage.editText?.setText("")
                binding.times.setText("")
                status = "$i of $recurNumber pushed"
                Snackbar.make(
                    binding.times,
                    "$recurNumber message(s) pushed to $recipientNumber",
                    Snackbar.LENGTH_LONG
                ).show()

                val messageDetails =
                    MessageProperty(0, messageBody, recipientNumber, dateAndTime(), status)
                viewModel.messageDetails.value = messageDetails

                viewModel.startInsert.observe(this, Observer {
                    viewModel.startInsert.value = true
                })
            }
        }

        Log.i(
            "MESSAGE_LOG",
            "${dateAndTime()}: You want to send '$messageBody' to $recipientNumber, $recurNumber times."
        )

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            sendSMS()
        } else {
            Toast.makeText(applicationContext, "SMS failed, please try again", Toast.LENGTH_LONG)
                .show()
            return
        }
    }

    companion object {
        private const val SENT_SMS_FLAG = "SENT_SMS"
        private const val SMS_REQUEST_CODE = 0
    }

}