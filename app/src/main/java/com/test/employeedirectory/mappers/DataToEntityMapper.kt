package com.test.employeedirectory.mappers

import com.test.employeedirectory.data.entity.CompanyDetailsEntity
import com.test.employeedirectory.data.entity.EmployeeDetailsEntity
import com.test.employeedirectory.data.entity.EmployeeEntity
import com.test.employeedirectory.data.model.EmployeeItem

fun EmployeeItem.toEntity() : EmployeeEntity {
    return EmployeeEntity(id = id, name = name, image = profileImage ?: "", companyName = company?.name ?: "")
}
fun EmployeeItem.toEntityDetails() : EmployeeDetailsEntity {
    return EmployeeDetailsEntity(id = id, name = name, image = profileImage ?: "",
        companyDetails = CompanyDetailsEntity(name = company?.name ?: "", catchPhrase = company?.catchPhrase ?: "", bs = company?.bs ?: "")
    )
}