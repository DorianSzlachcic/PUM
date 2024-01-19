package com.example.lista5.viewmodel

import android.app.Application
import com.example.lista5.model.Grade
import com.example.lista5.model.GradeRepository
import com.example.lista5.model.SubjectAndGrade

class GradeViewModel(application: Application) {
    private val repository = GradeRepository(application)

    fun getGrades() = repository.getGrades()
    fun deleteGrade(grade: Grade) = repository.deleteGrade(grade)

    fun validateAndInsertGrade(grade: Grade): Boolean {
        if (grade.subject == "")
            return false
        if (grade.grade.toFloat() > 6 || grade.grade.toFloat() < 1)
            return false
        repository.insertGrade(grade)
        return true
    }
    fun validateAndUpdateGrade(grade: Grade): Boolean {
        if (grade.subject == "")
            return false
        if (grade.grade.toFloat() > 6 || grade.grade.toFloat() < 1)
            return false
        repository.updateGrade(grade)
        return true
    }

    fun getGrade(id: Int) = repository.getGrades().find { it.uid == id } ?: Grade(0, "", "1")
}