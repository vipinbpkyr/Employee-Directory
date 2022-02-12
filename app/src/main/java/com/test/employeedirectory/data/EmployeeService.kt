package com.test.employeedirectory.data

import com.test.employeedirectory.data.model.EmployeeItem
import retrofit2.http.GET

interface EmployeeService {
    @GET("http://www.mocky.io/v2/5d565297300000680030a986")
    fun fetchEmployees() : List<EmployeeItem>
}