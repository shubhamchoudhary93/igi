package com.shubham.igi.client.ui.receiptdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shubham.igi.client.data.repository.ReceiptRepository

class ReceiptDetailViewModelFactory(
    private val receiptId: Long,
    private val repo: ReceiptRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ReceiptDetailViewModel::class.java)) {
            return ReceiptDetailViewModel(receiptId, repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}