package com.example.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todolist.data.CasesDataBase
import com.example.todolist.model.CaseItem
import com.example.todolist.repository.CaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CaseViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<CaseItem>>
    private val repository: CaseRepository

    init {
        val caseDao = CasesDataBase.getDataBase(application).caseDao()
        repository = CaseRepository(caseDao)
        readAllData = repository.readAllData
    }

    fun addCaseItem(caseItem: CaseItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCaseItem(caseItem)
        }
    }

    fun updateCaseItem(caseItem: CaseItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCaseItem(caseItem)
        }
    }

    fun deleteCaseItem(caseItem: CaseItem){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCaseItem(caseItem)
        }
    }

    fun deleteAllData(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllData()
        }
    }
}