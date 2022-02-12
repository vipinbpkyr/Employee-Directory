package com.test.employeedirectory.data.model


import com.google.gson.annotations.SerializedName

data class EmployeeItem(
    @SerializedName("address")
    val address: Address,
    @SerializedName("company")
    val company: Company?,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("profile_image")
    val profileImage: String?,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String?
)