package com.shubham.igi.client.domain.usecase

import com.shubham.igi.client.data.model.Receipt
import com.shubham.igi.client.data.repository.ReceiptRepository

class GetClientReceiptsUseCase(private val repo: ReceiptRepository) {
    suspend operator fun invoke(clientId: Long): List<Receipt> =
        repo.getReceiptsForClient(clientId)
}