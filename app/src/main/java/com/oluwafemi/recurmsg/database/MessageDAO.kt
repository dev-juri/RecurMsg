package com.oluwafemi.recurmsg.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oluwafemi.recurmsg.model.MessageProperty

@Dao
interface MessageDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNewMessage(vararg messageProperty: MessageProperty)

    @Query("select * from MessageProperty")
    suspend fun getAllMessages() : List<MessageProperty>
}