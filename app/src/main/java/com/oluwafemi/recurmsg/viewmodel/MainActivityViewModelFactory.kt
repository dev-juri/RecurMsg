package com.oluwafemi.recurmsg.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oluwafemi.recurmsg.database.MessageDAO

class MainActivityViewModelFactory(private val dataSource : MessageDAO, private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}