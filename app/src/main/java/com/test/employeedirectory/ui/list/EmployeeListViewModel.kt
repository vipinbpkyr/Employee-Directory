package com.test.employeedirectory.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.employeedirectory.domain.usecases.FetchEmployees
import com.test.employeedirectory.domain.usecases.GetEmployees
import com.test.employeedirectory.ui.vo.Employee
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UiState(
    val loading: Boolean = false,
    val errorMessage: String = "",
    val employees: List<Employee>? = null
)

@HiltViewModel
class EmployeeListViewModel @Inject constructor (
    val fetchEmployees: FetchEmployees,
    val getEmployees: GetEmployees
) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState(loading = true))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun getEmployees() {
        viewModelScope.launch {
            getEmployees.invoke().collect {
                _uiState.value = _uiState.value.copy(employees = it)
            }
        }
    }

    fun fetchEmployees() {
        viewModelScope.launch { fetchEmployees.invoke() }
    }
}