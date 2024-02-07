package com.example.todolist.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.model.CaseItem

@Dao
interface CaseDao {

    // Add case to DB
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCaseItem(caseItem: CaseItem)

    // Update case in DB
    @Update
    suspend fun updateCaseItem(caseItem: CaseItem)

    // Delete case from DB
    @Delete
    suspend fun deleteCaseItem(caseItem: CaseItem)

    // Delete all data from DB
    @Query("DELETE FROM cases_table")
    suspend fun deleteAllData()

    // Read data from DB
    @Query("SELECT * FROM cases_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<CaseItem>>
}