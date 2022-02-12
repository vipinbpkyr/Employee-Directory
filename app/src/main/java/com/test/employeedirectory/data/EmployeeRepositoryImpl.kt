package com.test.employeedirectory.data

import com.test.employeedirectory.domain.EmployeeRepository
import com.test.employeedirectory.mappers.toEntity
import com.test.employeedirectory.mappers.toEntityDetails
import com.test.employeedirectory.mappers.toPresentation
import com.test.employeedirectory.ui.vo.Employee
import com.test.employeedirectory.ui.vo.EmployeeDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(val service: EmployeeService,
                                                 private val employeeDao : EmployeeDao,
                                                 val dispatcher: CoroutineDispatcher
) : EmployeeRepository {
    override suspend fun fetchEmployees() {
        withContext(dispatcher){
            val list = service.fetchEmployees()

            list.forEach {
                employeeDao.insertEmployee(it.toEntity())
                employeeDao.insertEmployeeDetails(it.toEntityDetails())
            }
        }
    }

    override fun getEmployees(): Flow<List<Employee>> {
        return employeeDao.getEmployees().distinctUntilChanged().map {
            it.map { it.toPresentation() }
        }
    }
    override fun getEmployeesDetails(id: Int): Flow<EmployeeDetails> {
        return employeeDao.getEmployeesDetails(id).distinctUntilChanged().map { it.toPresentation() }
    }

    override fun searchEmployees() {
        TODO("Not yet implemented")
    }
}