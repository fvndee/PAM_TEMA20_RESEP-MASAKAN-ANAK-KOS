package com.example.p4.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun KolomTeks(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keterangan: String? = null,
    salah: Boolean = false,
    angka: Boolean = false,
    barisBanyak: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        supportingText = keterangan?.let { { Text(it) } },
        isError = salah,
        singleLine = !barisBanyak,
        minLines = if (barisBanyak) 3 else 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = if (angka) KeyboardType.Number else KeyboardType.Text
        ),
        modifier = Modifier.fillMaxWidth()
    )
}
