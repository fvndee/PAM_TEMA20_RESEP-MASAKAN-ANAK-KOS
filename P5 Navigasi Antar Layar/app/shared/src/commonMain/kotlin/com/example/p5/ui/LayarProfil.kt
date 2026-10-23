package com.example.p5.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val anggota = listOf(
    "Hanung Akbar Pramusintho" to "124140207",
    "Rajendra Rifandy" to "124140099",
    "Firman Luthfiansyah" to "124140044"
)

@Composable
fun LayarProfil() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Profil", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text("Resep Masakan Anak Kos, Tema 20", color = Color.Gray)
        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("Kelompok 6", fontWeight = FontWeight.Bold)
                anggota.forEach { (nama, nim) -> Text("$nama ($nim)") }
            }
        }
        Text("Pengaturan menyusul di pertemuan berikutnya.", color = Color.Gray)
    }
}
