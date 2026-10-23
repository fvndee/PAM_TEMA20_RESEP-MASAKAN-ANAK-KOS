package com.example.p5.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LayarAsisten() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Asisten Resep", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text("Tulis bahan yang tersisa di kamar kos, asisten menyarankan resep yang bisa dibuat.")
        Text("Fitur AI diisi di Modul 9.", color = Color.Gray)
    }
}
