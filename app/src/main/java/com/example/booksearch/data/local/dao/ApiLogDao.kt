package com.example.booksearch.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.booksearch.data.local.entity.ApiLogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ApiLogDao {

    @Insert
    suspend fun insert(log: ApiLogEntity)

    @Query("SELECT * FROM api_logs ORDER BY timestamp DESC")
    fun getAllLogs(): Flow<List<ApiLogEntity>>

    @Query("DELETE FROM api_logs")
    suspend fun clearAll()
}
