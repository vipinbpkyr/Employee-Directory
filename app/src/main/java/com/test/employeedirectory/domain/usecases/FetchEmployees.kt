package com.test.employeedirectory.domain.usecases

import com.test.employeedirectory.domain.EmployeeRepository
import javax.inject.Inject

class FetchEmployees @Inject constructor (val repo : EmployeeRepository) {
    suspend operator fun invoke(){
        repo.fetchEmployees()
    }
}