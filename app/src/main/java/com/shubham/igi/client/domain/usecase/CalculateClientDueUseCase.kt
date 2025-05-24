package com.shubham.igi.client.domain.usecase

import com.shubham.igi.client.data.repository.ReceiptRepository

class CalculateClientDueUseCase(private val repo: ReceiptRepository) {
    suspend operator fun invoke(clientId: Long): Double =
        repo.calculateClientDue(clientId)
}