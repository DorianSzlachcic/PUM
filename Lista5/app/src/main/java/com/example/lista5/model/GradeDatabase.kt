package com.example.lista5.model

import android.app.Application
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Grade::class], version = 2)
abstract class GradeDatabase : RoomDatabase() {
    abstract fun getDao() : GradeDao
}