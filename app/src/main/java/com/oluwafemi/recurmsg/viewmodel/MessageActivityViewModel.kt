package com.oluwafemi.recurmsg.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.oluwafemi.recurmsg.database.getDatabase
import com.oluwafemi.recurmsg.model.MessageProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MessageActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val job = SupervisorJob()
    val coroutineScope = CoroutineScope(job + Dispatchers.Default)

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }


    fun insertMessage(messageDetails: MessageProperty) {
        coroutineScope.launch {
            val databaseInstance = getDatabase(getApplication()).messageDAO
            try {
                databaseInstance.insertNewMessage(messageDetails)
            } catch (e: Exception) {
                Log.e("DB_Insert_Log", e.toString())
            }
        }
    }


}