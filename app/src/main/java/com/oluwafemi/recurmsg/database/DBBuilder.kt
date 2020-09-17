package com.oluwafemi.recurmsg.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oluwafemi.recurmsg.model.MessageProperty


@Database(entities = [MessageProperty::class], version = 1, exportSchema = false)
abstract class MessageDatabase : RoomDatabase() {
    abstract val messageDAO: MessageDAO
}

private lateinit var Instance: MessageDatabase
fun getDatabase(context: Context): MessageDatabase {
    synchronized(MessageDatabase::class.java) {
        if (!::Instance.isInitialized) {
            Instance = Room.databaseBuilder(
                context.applicationContext,
                MessageDatabase::class.java,
                "MessageDatabase"
            ).build()
        }
    }
    return Instance
}
