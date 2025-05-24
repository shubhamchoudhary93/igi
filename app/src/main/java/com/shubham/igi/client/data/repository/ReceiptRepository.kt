package com.shubham.igi.client.data.repository

import android.content.Context
import com.shubham.igi.client.data.dao.ClientDao
import com.shubham.igi.client.data.dao.ReceiptDao
import com.shubham.igi.client.data.model.Client
import com.shubham.igi.client.data.model.ClientWithReceipts
import com.shubham.igi.client.data.model.Receipt
import com.shubham.igi.utils.backupDatabase

class ReceiptRepository(
    private val clientDao: ClientDao,
    private val receiptDao: ReceiptDao,
    private val context: Context
) {

    suspend fun addClient(client: Client): Long {
        val id = clientDao.insertClient(client)
        backupDatabase(context)
        return id
    }

    suspend fun getAllClients(): List<Client> = clientDao.getAllClients()

    suspend fun getClientWithReceipts(clientId: Long): ClientWithReceipts? =
        clientDao.getClientWithReceipts(clientId)

    suspend fun addReceipt(receipt: Receipt): Long {
        val id = receiptDao.insertReceipt(receipt)
        backupDatabase(context)
        return id
    }

    suspend fun updateReceipt(receipt: Receipt) {
        receiptDao.updateReceipt(receipt)
        backupDatabase(context)
    }

    suspend fun getReceiptsForClient(clientId: Long): List<Receipt> =
        receiptDao.getReceiptsForClient(clientId)

    suspend fun getReceipt(receiptId: Long): Receipt? = receiptDao.getReceipt(receiptId)

    suspend fun calculateClientDue(clientId: Long): Double {
        val receipts = receiptDao.getReceiptsForClient(clientId)
        return receipts.sumOf { it.amount - it.paidAmount }
    }

    suspend fun updateClient(client: Client) {
        clientDao.updateClient(client)
        backupDatabase(context)
    }

    suspend fun deleteClient(client: Client) {
        clientDao.deleteClient(client)
        backupDatabase(context)
    }
}