package com.test.employeedirectory.di

import com.google.gson.GsonBuilder
import com.test.employeedirectory.data.EmployeeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideAnalyticsService(
        // Potential dependencies of this type
    ): EmployeeService {
        val gson = GsonBuilder()
            .create()

        return Retrofit.Builder()
            .baseUrl("http://www.mocky.io/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(EmployeeService::class.java)
    }
}