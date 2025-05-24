package com.shubham.igi.client.domain.usecase

import com.shubham.igi.client.data.model.Client
import com.shubham.igi.client.data.repository.ReceiptRepository

data class ClientWithDue(
    val client: Client,
    val dueAmount: Double
)

class GetClientsWithDueUseCase(private val repo: ReceiptRepository) {
    suspend operator fun invoke(): List<ClientWithDue> {
        return repo.getAllClients().map { client ->
            val due = repo.calculateClientDue(client.clientId)
            ClientWithDue(client, due)
        }
    }
}