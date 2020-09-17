package com.oluwafemi.recurmsg.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.oluwafemi.recurmsg.R
import com.oluwafemi.recurmsg.adapter.MessageAdapter
import com.oluwafemi.recurmsg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.lifecycleOwner = this

        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, MessageActivity::class.java)
            startActivity(intent)
        }
        binding.messageList.adapter = MessageAdapter()

    }
}