package com.shubham.igi.client.ui.clientdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubham.igi.client.data.model.Client
import com.shubham.igi.client.data.model.Receipt
import com.shubham.igi.client.data.repository.ReceiptRepository
import com.shubham.igi.client.domain.usecase.CalculateClientDueUseCase
import com.shubham.igi.client.domain.usecase.GetClientReceiptsUseCase
import kotlinx.coroutines.launch

class ClientDetailViewModel(
    private val clientId: Long,
    private val repo: ReceiptRepository,
    private val getClientReceipts: GetClientReceiptsUseCase,
    private val calculateDue: CalculateClientDueUseCase
) : ViewModel() {

    var client by mutableStateOf<Client?>(null)
        private set

    var receipts by mutableStateOf<List<Receipt>>(emptyList())
        private set

    var dueAmount by mutableStateOf(0.0)
        private set

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            client = repo.getClientWithReceipts(clientId)?.client
            receipts = getClientReceipts(clientId)
            dueAmount = calculateDue(clientId)
        }
    }

    fun refresh() {
        loadData()
    }
}