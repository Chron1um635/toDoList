package com.example.todolist.repository

import androidx.lifecycle.LiveData
import com.example.todolist.data.CaseDao
import com.example.todolist.model.CaseItem

class CaseRepository(private val caseDao: CaseDao) {
    val readAllData: LiveData<List<CaseItem>> = caseDao.readAllData()

    suspend fun addCaseItem(caseItem: CaseItem) {
        caseDao.addCaseItem(caseItem)
    }

    suspend fun updateCaseItem(caseItem: CaseItem) {
        caseDao.updateCaseItem(caseItem)
    }

    suspend fun deleteCaseItem(caseItem: CaseItem) {
        caseDao.deleteCaseItem(caseItem)
    }

    suspend fun deleteAllData(){
        caseDao.deleteAllData()
    }
}