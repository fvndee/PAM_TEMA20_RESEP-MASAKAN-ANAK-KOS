package com.example.p5.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p5.model.Resep
import com.example.p5.model.StatusResep

@Composable
fun LayarDetail(
    state: DetailUiState,
    kembali: () -> Unit,
    onSetujui: () -> Unit,
    onTolak: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextButton(onClick = kembali) { Text("Kembali") }
        when (state) {
            DetailUiState.Memuat -> CircularProgressIndicator()
            DetailUiState.TidakDitemukan -> Text("Resep tidak ditemukan")
            is DetailUiState.Ada -> IsiDetail(state.resep, onSetujui, onTolak)
        }
    }
}

@Composable
private fun IsiDetail(resep: Resep, onSetujui: () -> Unit, onTolak: () -> Unit) {
    FotoResep(resep)
    Text(resep.nama, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    Text(resep.deskripsi, color = Color.Gray)
    BarisInfo(resep.kategori.nama, resep.alatMasak, resep.waktuMasakMenit)
    Text("${formatRupiah(resep.estimasiBiaya)} untuk ${resep.porsi} porsi", fontWeight = FontWeight.Bold)

    Text("Bahan", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 8.dp))
    resep.bahan.forEach { Text("• $it") }

    Text("Langkah", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(top = 8.dp))
    resep.langkah.forEachIndexed { urutan, langkah -> Text("${urutan + 1}. $langkah") }

    if (resep.status is StatusResep.Diajukan) {
        Row(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = onSetujui) { Text("Setujui") }
            OutlinedButton(onClick = onTolak) { Text("Tolak") }
        }
    }
}
