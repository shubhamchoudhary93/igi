package com.shubham.igi.client.ui.clientlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igi.client.domain.usecase.GetClientsWithDueUseCase

class ClientListViewModelFactory(
    private val getClientsWithDue: GetClientsWithDueUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientListViewModel::class.java)) {
            return ClientListViewModel(getClientsWithDue) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}