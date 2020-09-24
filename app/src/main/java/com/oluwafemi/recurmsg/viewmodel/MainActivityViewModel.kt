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

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    private lateinit var _messageList: List<MessageProperty>
    val messageList: List<MessageProperty>
        get() = _messageList

    init {
        getAllMessages()
    }

    private fun getAllMessages() {
        coroutineScope.launch {
            val databaseInstance = getDatabase(getApplication()).messageDAO
            _messageList = databaseInstance.getAllMessages()
            Log.i("DB_List", _messageList.toString())
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}