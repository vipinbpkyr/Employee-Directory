package com.test.employeedirectory.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.employeedirectory.ui.FullScreenLoading
import com.test.employeedirectory.ui.NetworkImageView
import com.test.employeedirectory.ui.vo.CompanyDetails
import com.test.employeedirectory.ui.vo.EmployeeDetails

@Composable
fun EmployeeDetailsPage(id: Int, viewModel: EmployeeDetailsViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    viewModel.getEmployees(id)
    if (uiState.loading) {
        FullScreenLoading()
    } else {
        uiState.employee?.let { EmployeeDetailsView(it) }
    }

}

@Composable
fun EmployeeDetailsView(employee: EmployeeDetails) {
    Row(modifier = Modifier.padding(8.dp)) {
        NetworkImageView(
            imageUrl = employee.image, modifier = Modifier
                .size(50.dp),
            contentDescription = "employee"
        )
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = employee.name
            )
            companyDetailsView(employee.companyDetails)
        }
    }
}

@Composable
fun companyDetailsView(company: CompanyDetails) {

    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = company.name
        )
        Text(
            text = company.catchPhrase
        )
        Text(
            text = company.bs
        )
    }

}
