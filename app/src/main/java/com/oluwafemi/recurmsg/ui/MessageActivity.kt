package com.oluwafemi.recurmsg.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.oluwafemi.recurmsg.R
import com.oluwafemi.recurmsg.databinding.ActivityMessageBinding

class MessageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMessageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_message)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val recipientNumber = binding.phoneNumber.editText?.text
        val messageBody = binding.textMessage.editText?.text
        val recurNumber = binding.times.text

        binding.sendBtn.setOnClickListener {
            if (!recipientNumber.isNullOrEmpty() && !messageBody.isNullOrEmpty() && !recurNumber.isNullOrEmpty()){
                Log.i("MESSAGE_LOG", "You want to send '$messageBody' to $recipientNumber, $recurNumber times.")
            } else {
                Toast.makeText(applicationContext, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp()
    }
}