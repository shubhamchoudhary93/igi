package com.shubham.igi.client.domain.usecase

import com.shubham.igi.client.data.repository.ReceiptRepository

class MarkReceiptPaidUseCase(private val repo: ReceiptRepository) {
    suspend operator fun invoke(receiptId: Long, paidAmount: Double) {
        val receipt = repo.getReceipt(receiptId)
        if (receipt != null) {
            repo.updateReceipt(receipt.copy(paidAmount = paidAmount))
        }
    }
}