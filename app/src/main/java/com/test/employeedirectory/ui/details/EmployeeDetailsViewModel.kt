package com.test.employeedirectory.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.employeedirectory.domain.usecases.GetEmployeeDetails
import com.test.employeedirectory.ui.vo.EmployeeDetails
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
    val employee: EmployeeDetails? = null
)

@HiltViewModel
class EmployeeDetailsViewModel @Inject constructor (val getEmployeeDetails: GetEmployeeDetails) : ViewModel() {
    private val _uiState = MutableStateFlow(UiState(loading = true))
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun getEmployees(id: Int) {
        viewModelScope.launch {
            getEmployeeDetails.invoke(id).collect {
                _uiState.value = _uiState.value.copy(employee = it)
            }
        }
    }
}