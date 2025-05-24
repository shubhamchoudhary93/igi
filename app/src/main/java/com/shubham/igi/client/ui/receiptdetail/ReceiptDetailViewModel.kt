package com.shubham.igi.client.ui.receiptdetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubham.igi.client.data.model.Receipt
import com.shubham.igi.client.data.repository.ReceiptRepository
import kotlinx.coroutines.launch

class ReceiptDetailViewModel(
    private val receiptId: Long,
    private val repo: ReceiptRepository
) : ViewModel() {

    var receipt by mutableStateOf<Receipt?>(null)
        private set

    init {
        loadReceipt()
    }

    private fun loadReceipt() {
        viewModelScope.launch {
            receipt = repo.getReceipt(receiptId)
        }
    }

    fun updatePaidAmount(paidAmount: Double) {
        receipt?.let {
            viewModelScope.launch {
                val updated = it.copy(paidAmount = paidAmount)
                repo.updateReceipt(updated)
                receipt = updated
            }
        }
    }
}