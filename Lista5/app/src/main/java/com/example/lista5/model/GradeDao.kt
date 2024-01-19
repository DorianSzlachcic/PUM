package com.example.lista5.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface GradeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGrade(grade: Grade)

    @Query("SELECT * FROM grade")
    fun getGrades() : List<Grade>

    @Delete
    fun deleteGrade(grade: Grade)

    @Update
    fun updateGrade(grade: Grade)
}