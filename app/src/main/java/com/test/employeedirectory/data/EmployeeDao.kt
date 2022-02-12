package com.test.employeedirectory.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.test.employeedirectory.data.entity.EmployeeDetailsEntity
import com.test.employeedirectory.data.entity.EmployeeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM employeeentity")
    fun getEmployees(): Flow<List<EmployeeEntity>>

    @Query("SELECT * FROM EmployeeDetailsEntity WHERE `id` = :id" )
    fun getEmployeesDetails(id: Int): Flow<EmployeeDetailsEntity>

    @Insert
    fun insertEmployee(employee: EmployeeEntity)
    @Insert
    fun insertEmployeeDetails(employeeDetails: EmployeeDetailsEntity)

    @Insert
    fun insertEmployees(employee: List<EmployeeEntity>)
}