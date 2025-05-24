package com.shubham.igi.client.ui.addreceipt

import android.app.DatePickerDialog
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.shubham.igi.client.data.model.Receipt
import com.shubham.igi.utils.createImageFile
import java.time.LocalDate
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AddReceiptScreen(
    clientId: Long,
    onSave: (Receipt) -> Unit,
    onCancel: () -> Unit
) {
    val context = LocalContext.current

    var photoUri by remember { mutableStateOf<Uri?>(null) }
    var amount by remember { mutableStateOf("") }
    var date by remember { mutableStateOf(LocalDate.now()) }

    // Camera launcher
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
        // Do nothing, uri is already stored
    }

    // Date picker
    val datePicker = remember {
        DatePickerDialog(context).apply {
            val now = Calendar.getInstance()
            updateDate(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
            )
            setOnDateSetListener { _, year, month, day ->
                date = LocalDate.of(year, month + 1, day)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Add Receipt") })
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Button(onClick = {
                val (file, uri) = createImageFile(context)
                photoUri = uri
                cameraLauncher.launch(uri)
            }) {
                Text("Capture Receipt")
            }

            photoUri?.let {
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = rememberAsyncImagePainter(it),
                    contentDescription = "Receipt Photo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = amount,
                onValueChange = { amount = it },
                label = { Text("Amount") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(8.dp))

            OutlinedButton(onClick = { datePicker.show() }) {
                Text("Date: $date")
            }

            Spacer(Modifier.height(16.dp))

            Row {
                Button(
                    onClick = onCancel,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Cancel")
                }
                Spacer(Modifier.width(16.dp))
                Button(
                    onClick = {
                        if (photoUri != null && amount.toDoubleOrNull() != null) {
                            onSave(
                                Receipt(
                                    clientOwnerId = clientId,
                                    date = date,
                                    amount = amount.toDouble(),
                                    imageUri = photoUri.toString()
                                )
                            )
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Save")
                }
            }
        }
    }
}