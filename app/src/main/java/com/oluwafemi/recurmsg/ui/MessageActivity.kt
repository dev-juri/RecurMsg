package com.oluwafemi.recurmsg.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oluwafemi.recurmsg.R

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        return true
    }
}