package com.test.employeedirectory.domain.usecases

import com.test.employeedirectory.domain.EmployeeRepository
import com.test.employeedirectory.ui.vo.Employee
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmployees @Inject constructor (val repo : EmployeeRepository) {
    operator fun invoke() : Flow<List<Employee>> {
        return repo.getEmployees()
    }
}