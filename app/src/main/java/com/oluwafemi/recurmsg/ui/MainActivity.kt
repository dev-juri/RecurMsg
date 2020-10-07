package com.oluwafemi.recurmsg.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.oluwafemi.recurmsg.R
import com.oluwafemi.recurmsg.adapter.MessageAdapter
import com.oluwafemi.recurmsg.database.getDatabase
import com.oluwafemi.recurmsg.databinding.ActivityMainBinding
import com.oluwafemi.recurmsg.viewmodel.MainActivityViewModel
import com.oluwafemi.recurmsg.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val application = requireNotNull(this).application
        val dataSource = getDatabase(application).messageDAO
        val viewModelFactory = MainActivityViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.messageRecyclerView.apply {
            adapter = MessageAdapter()
        }

       viewModel.messageList.observe(this, Observer {
            //binding.messageList.text = it.toString()
           Log.i("DB LIST", it.toString())
        })


        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, MessageActivity::class.java)
            startActivity(intent)
        }

    }
}