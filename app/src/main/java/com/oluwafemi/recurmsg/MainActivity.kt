package com.oluwafemi.recurmsg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.oluwafemi.recurmsg.databinding.ActivityMainBinding
import com.oluwafemi.recurmsg.ui.MessageActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, MessageActivity::class.java)
            startActivity(intent)
        }
    }
}