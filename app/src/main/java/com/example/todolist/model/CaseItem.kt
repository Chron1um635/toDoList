package com.example.todolist.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "cases_table")
data class CaseItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val isDone: Boolean = false,
    val dateOfCreation: String
): Parcelable
