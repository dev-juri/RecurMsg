package com.oluwafemi.recurmsg.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oluwafemi.recurmsg.database.getDatabase
import com.oluwafemi.recurmsg.model.MessageProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    var messageList = listOf<MessageProperty>()

    init {
        getAllMessages()
    }

    private fun getAllMessages() {
        coroutineScope.launch {
            val databaseInstance = getDatabase(getApplication()).messageDAO
            try {
                messageList = databaseInstance.getAllMessages()
                Log.i("DB_List", messageList.toString())
            } catch (e : Exception) {
                Log.e("DB_List", e.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}