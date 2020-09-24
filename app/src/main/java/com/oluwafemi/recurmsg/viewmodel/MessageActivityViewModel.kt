package com.oluwafemi.recurmsg.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.oluwafemi.recurmsg.model.MessageProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MessageActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    lateinit var messageDetails: MessageProperty

    var startInsert = false

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    init {
        coroutineScope.launch {
            callInsert()
        }
    }

    private suspend fun insertMessage(messageDetails: MessageProperty) {
        coroutineScope.launch {
            try {
                insertMessage(messageDetails)
            } catch (e: Exception) {
                Log.e("DB_Insert_Log", e.toString())
            }
        }
    }

    private suspend fun callInsert() {
        if (startInsert) {
            insertMessage(messageDetails)
            startInsert = false
        }
    }
}