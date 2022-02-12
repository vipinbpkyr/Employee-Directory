package com.test.employeedirectory.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EmployeeEntity(@PrimaryKey val id: Int, val name: String, val image: String, val companyName: String)