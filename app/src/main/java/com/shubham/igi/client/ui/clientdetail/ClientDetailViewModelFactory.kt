package com.shubham.igi.client.ui.clientdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igi.client.data.repository.ReceiptRepository
import com.shubham.igi.client.domain.usecase.CalculateClientDueUseCase
import com.shubham.igi.client.domain.usecase.GetClientReceiptsUseCase

class ClientDetailViewModelFactory(
    private val clientId: Long,
    private val repo: ReceiptRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClientDetailViewModel::class.java)) {
            return ClientDetailViewModel(
                clientId,
                repo,
                GetClientReceiptsUseCase(repo),
                CalculateClientDueUseCase(repo)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}