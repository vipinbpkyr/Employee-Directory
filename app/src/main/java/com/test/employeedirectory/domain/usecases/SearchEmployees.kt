package com.test.employeedirectory.domain.usecases

import com.test.employeedirectory.domain.EmployeeRepository
import javax.inject.Inject

class SearchEmployees @Inject constructor (val repo : EmployeeRepository) {
    operator fun invoke(){
        repo.searchEmployees()
    }
}