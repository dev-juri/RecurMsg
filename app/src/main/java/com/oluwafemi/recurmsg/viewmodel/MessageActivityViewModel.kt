package com.oluwafemi.recurmsg.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.oluwafemi.recurmsg.model.MessageProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import java.lang.Exception

class MessageActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    private suspend fun insertMessage(messageDetails: MessageProperty) {
        try {
            insertMessage(messageDetails)
        } catch (e : Exception) {
            Log.e("DB_Insert_Log", e.toString())
        }
    }
}