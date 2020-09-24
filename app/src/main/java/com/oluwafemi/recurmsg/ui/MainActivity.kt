package com.oluwafemi.recurmsg.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oluwafemi.recurmsg.R
import com.oluwafemi.recurmsg.adapter.MessageAdapter
import com.oluwafemi.recurmsg.databinding.ActivityMainBinding
import com.oluwafemi.recurmsg.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, MessageActivity::class.java)
            startActivity(intent)
        }
        binding.messageList.adapter = MessageAdapter()

    }
}