package com.shubham.igi.client.ui.clientlist

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubham.igi.client.domain.usecase.ClientWithDue
import com.shubham.igi.client.domain.usecase.GetClientsWithDueUseCase
import kotlinx.coroutines.launch

class ClientListViewModel(
    private val getClientsWithDue: GetClientsWithDueUseCase
) : ViewModel() {

    private val _uiState = mutableStateOf<List<ClientWithDue>>(emptyList())
    val uiState: State<List<ClientWithDue>> = _uiState

    var showOnlyDue by mutableStateOf(false)
    val filteredClients: List<ClientWithDue>
        get() = if (showOnlyDue) uiState.value.filter { it.dueAmount > 0.0 } else uiState.value

    init {
        viewModelScope.launch {
            _uiState.value = getClientsWithDue()
        }
    }
}