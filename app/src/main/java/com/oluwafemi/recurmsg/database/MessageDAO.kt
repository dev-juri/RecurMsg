package com.oluwafemi.recurmsg.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oluwafemi.recurmsg.model.MessageProperty

@Dao
interface MessageDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewMessage(messageProperty: MessageProperty)

    @Query("Select * from Messages")
    suspend fun getAllMessages() : List<MessageProperty>
}