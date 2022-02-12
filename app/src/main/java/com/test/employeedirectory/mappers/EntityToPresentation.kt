package com.test.employeedirectory.mappers

import com.test.employeedirectory.data.entity.CompanyDetailsEntity
import com.test.employeedirectory.data.entity.EmployeeDetailsEntity
import com.test.employeedirectory.data.entity.EmployeeEntity
import com.test.employeedirectory.ui.vo.CompanyDetails
import com.test.employeedirectory.ui.vo.Employee
import com.test.employeedirectory.ui.vo.EmployeeDetails

fun EmployeeEntity.toPresentation() : Employee {
    return Employee(id, name, image, companyName)
}
fun CompanyDetailsEntity.toPresentation() : CompanyDetails {
    return CompanyDetails(name, catchPhrase, bs)
}
fun EmployeeDetailsEntity.toPresentation() : EmployeeDetails {
    return EmployeeDetails(id = id, name = name, image = image, companyDetails = companyDetails.toPresentation())
}