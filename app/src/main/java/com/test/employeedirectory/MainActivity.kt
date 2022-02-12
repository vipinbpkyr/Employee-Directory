package com.test.employeedirectory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.test.employeedirectory.ui.details.EmployeeDetailsPage
import com.test.employeedirectory.ui.list.EmployeeListPage
import com.test.employeedirectory.ui.theme.EmployeeDirectoryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmployeeDirectoryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "employees") {
                        composable("employees") { EmployeeListPage(navigateToDetails = {
                            navController.navigate("employee_details?Id=$it")
                        }) }
                        composable("employee_details",) { backStackEntry ->
                            EmployeeDetailsPage(backStackEntry.arguments?.getInt("Id") ?: 0)
                        }
                    }
                }
            }
        }
    }
}