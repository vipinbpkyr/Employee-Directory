package com.test.employeedirectory.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.employeedirectory.data.entity.EmployeeDetailsEntity
import com.test.employeedirectory.data.entity.EmployeeEntity

@Database(entities = [EmployeeEntity::class, EmployeeDetailsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
}