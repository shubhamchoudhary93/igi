package com.shubham.igi.client.domain.usecase

import com.shubham.igi.client.data.model.Receipt
import com.shubham.igi.client.data.repository.ReceiptRepository

class AddReceiptUseCase(private val repo: ReceiptRepository) {
    suspend operator fun invoke(receipt: Receipt): Long = repo.addReceipt(receipt)
}