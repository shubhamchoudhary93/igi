package com.shubham.igi.client.ui.receiptdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.shubham.igi.inventory.ui.components.ConfirmationBottomSheet
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptDetailScreen(
    viewModel: ReceiptDetailViewModel,
    onBack: () -> Unit,
    onUpdated: () -> Unit
) {
    val receipt = viewModel.receipt
    var paidInput by remember { mutableStateOf("") }
    var showConfirmSheet by remember { mutableStateOf(false) }
    var confirmAmount by remember { mutableStateOf(0.0) }

    val snackbarHostState = remember { SnackbarHostState() }
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Receipt Detail") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        receipt?.let {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {

                Image(
                    painter = rememberAsyncImagePainter(it.imageUri),
                    contentDescription = "Receipt Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                Spacer(Modifier.height(16.dp))

                Text("Date: ${it.date}")
                Text("Amount: ₹%.2f".format(it.amount))
                Text("Paid: ₹%.2f".format(it.paidAmount))

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = paidInput,
                    onValueChange = { paidInput = it },
                    label = { Text("Enter paid amount") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(16.dp))

                Row {
                    Button(
                        onClick = {
                            confirmAmount = it.amount
                            showConfirmSheet = true
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Mark Fully Paid")
                    }

                    Spacer(Modifier.width(16.dp))

                    Button(
                        onClick = {
                            paidInput.toDoubleOrNull()?.let { amt ->
                                confirmAmount = amt
                                showConfirmSheet = true
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Mark Partial")
                    }
                }
            }
        } ?: Text("Loading...", modifier = Modifier.padding(16.dp))
    }

    if (showConfirmSheet) {
        ConfirmationBottomSheet(
            title = "Mark ₹%.2f as paid?".format(confirmAmount),
            onDismiss = { showConfirmSheet = false },
            onConfirm = {
                showConfirmSheet = false
                viewModel.updatePaidAmount(confirmAmount)
                onUpdated()
                scope.launch {
                    snackbarHostState.showSnackbar("Marked ₹%.2f as paid.".format(confirmAmount))
                }
            },
            bottomSheetState = bottomSheetState
        )
    }
}