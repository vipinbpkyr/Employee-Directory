package com.test.employeedirectory.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class CompanyDetailsEntity(@PrimaryKey val name : String,
                           val catchPhrase : String, val bs : String) {
}