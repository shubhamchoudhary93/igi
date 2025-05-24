package com.shubham.igi.client.domain.usecase

import com.shubham.igi.client.data.model.Client
import com.shubham.igi.client.data.repository.ReceiptRepository

class AddClientUseCase(private val repo: ReceiptRepository) {
    suspend operator fun invoke(client: Client): Long = repo.addClient(client)
}