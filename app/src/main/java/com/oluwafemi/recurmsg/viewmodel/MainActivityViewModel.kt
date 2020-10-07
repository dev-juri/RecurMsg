package com.oluwafemi.recurmsg.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.oluwafemi.recurmsg.database.MessageDAO
import com.oluwafemi.recurmsg.model.MessageProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainActivityViewModel(private val database: MessageDAO, application: Application) :
    AndroidViewModel(application) {
    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    private var _messageList = MutableLiveData<List<MessageProperty>>()
    val messageList : LiveData<List<MessageProperty>>
        get() = _messageList

    init {
        coroutineScope.launch {
            _messageList.value = database.getAllMessages()
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}