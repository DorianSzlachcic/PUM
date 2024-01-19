package com.example.lista5.model

import android.app.Application
import androidx.room.Room

class GradeRepository(application: Application) {
    private val db = Room.databaseBuilder(
        application,
        GradeDatabase::class.java,
        "grade_database"
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    private val dbDao = db.getDao()

    fun getGrades() = dbDao.getGrades()
    fun insertGrade(grade: Grade) = dbDao.insertGrade(grade)
    fun deleteGrade(grade: Grade) = dbDao.deleteGrade(grade)
    fun updateGrade(grade: Grade) = dbDao.updateGrade(grade)
}