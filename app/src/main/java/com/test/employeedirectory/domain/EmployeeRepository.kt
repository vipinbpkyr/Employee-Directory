package com.test.employeedirectory.domain

import com.test.employeedirectory.ui.vo.Employee
import com.test.employeedirectory.ui.vo.EmployeeDetails
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    suspend fun fetchEmployees()
    fun getEmployees(): Flow<List<Employee>>
    fun getEmployeesDetails(id:Int): Flow<EmployeeDetails>
    fun searchEmployees()
}