package com.example.lista5.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grade")
data class Grade(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    val subject: String,
    val grade: String,
)
