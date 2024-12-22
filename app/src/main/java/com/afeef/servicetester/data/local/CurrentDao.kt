/*
package com.afeef.servicetester.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afeef.servicetester.data.model.CurrentState
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrentDao {
    @Query("SELECT * FROM current_state")
    fun getAllUrl(): Flow<List<CurrentState>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(rates: List<CurrentState>)
}*/
