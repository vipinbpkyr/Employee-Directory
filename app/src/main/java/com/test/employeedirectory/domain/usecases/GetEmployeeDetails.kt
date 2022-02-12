package com.test.employeedirectory.domain.usecases

import com.test.employeedirectory.domain.EmployeeRepository
import com.test.employeedirectory.ui.vo.Employee
import com.test.employeedirectory.ui.vo.EmployeeDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmployeeDetails @Inject constructor (val repo : EmployeeRepository) {
    operator fun invoke(id:Int) : Flow<EmployeeDetails> {
        return repo.getEmployeesDetails(id)
    }
}