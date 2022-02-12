package com.test.employeedirectory.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.employeedirectory.ui.FullScreenLoading
import com.test.employeedirectory.ui.NetworkImageView
import com.test.employeedirectory.ui.vo.Employee

@Composable
fun EmployeeListPage(viewModel: EmployeeListViewModel = viewModel(),
                     navigateToDetails: (id: Int) -> Unit){
    val uiState by viewModel.uiState.collectAsState()
    viewModel.fetchEmployees()
    viewModel.getEmployees()

    if (uiState.loading) {
        FullScreenLoading()
    }else{

        val listState = rememberLazyListState()
        LazyColumn(content = {

        })
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            uiState.employees?.let { items ->
                LazyColumn(state = listState,){

                    items(count = items.size ?: 0, key = { message ->
                        // Return a stable + unique key for the item
                        message
                    })
                    { index ->
                        EmployeeItemView(items.get(index))
                    }
                }
            }
           
        }
    }
}

@Composable
fun EmployeeItemView(employee: Employee){
Row(modifier = Modifier.padding(8.dp)) {
    NetworkImageView(imageUrl = employee.image, modifier = Modifier
        .size(50.dp),
        contentDescription = "employee")
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = employee.name
        )
        Text(
            text = employee.companyName
        )
    }
}
}