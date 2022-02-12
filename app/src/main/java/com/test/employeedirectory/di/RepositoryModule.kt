package com.test.employeedirectory.di

import com.test.employeedirectory.data.EmployeeRepositoryImpl
import com.test.employeedirectory.domain.EmployeeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindTestRepository(
        employeeRepositoryImpl: EmployeeRepositoryImpl
    ): EmployeeRepository

}