package com.example.p4.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.p4.model.Resep

@Composable
fun FotoAtauKosong(url: String?) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF1EDE1)),
        contentAlignment = Alignment.Center
    ) {
        Text(if (url == null) "Belum ada foto" else "Foto tersedia", color = Color.Gray)
    }
}

@Composable
fun FotoResep(resep: Resep) {
    Box(
        modifier = Modifier.fillMaxWidth().height(120.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        FotoAtauKosong(resep.fotoUrl)
        LabelStatus(resep.status, Modifier.padding(8.dp))
    }
}
