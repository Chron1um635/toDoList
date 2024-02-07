package com.example.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.model.CaseItem

@Database(entities = [CaseItem::class], version = 1, exportSchema = false)
abstract class CasesDataBase: RoomDatabase() {
    abstract fun caseDao(): CaseDao

    companion object {
        @Volatile
        private var INSTANCE: CasesDataBase? = null

        fun getDataBase(context: Context): CasesDataBase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CasesDataBase::class.java,
                    "cases_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}