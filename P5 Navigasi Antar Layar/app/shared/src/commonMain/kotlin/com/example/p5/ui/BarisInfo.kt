package com.example.p5.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun BarisInfo(kategori: String, alat: String, menit: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(kategori, fontSize = 13.sp, modifier = Modifier.weight(1f))
        Text("$alat, $menit menit", fontSize = 13.sp, color = Color.Gray)
    }
}
