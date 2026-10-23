package com.example.p3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.p3.data.SumberResepPalsu
import com.example.p3.model.Resep
import com.example.p3.model.StatusResep
import com.example.p3.model.label

@Composable
fun App() {
    MaterialTheme {
        val sumber = remember { SumberResepPalsu() }
        val daftar by sumber.ambilSemua().collectAsState(initial = null)
        var urutBiaya by remember { mutableStateOf(false) }

        Scaffold(
            topBar = { TopAppBar(title = { Text("Resep Masakan Anak Kos") }) },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) { Text("+") }
            }
        ) { padding ->
            Column(Modifier.padding(padding).padding(horizontal = 16.dp).fillMaxSize()) {
                Row(
                    Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Daftar resep (${daftar?.size ?: 0})", style = MaterialTheme.typography.titleMedium)
                    OutlinedButton(onClick = { urutBiaya = !urutBiaya }) {
                        Text(if (urutBiaya) "Urutkan terbaru" else "Biaya termurah")
                    }
                }
                val resepTampil = daftar?.let {
                    if (urutBiaya) it.sortedBy { resep -> resep.estimasiBiaya }
                    else it.sortedByDescending { resep -> resep.id }
                }
                if (resepTampil == null) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
                } else {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(resepTampil, key = { it.id }) { KartuResep(it) }
                    }
                }
            }
        }
    }
}

@Composable
private fun KartuResep(resep: Resep) {
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(resep.nama, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(resep.status.label(), color = warnaStatus(resep.status), fontWeight = FontWeight.SemiBold)
            }
            Spacer(Modifier.height(4.dp))
            Text(resep.deskripsi)
            Text("${resep.kategori.nama} • ${resep.waktuMasakMenit} menit • Rp${resep.estimasiBiaya}", style = MaterialTheme.typography.bodySmall)
        }
    }
}

private fun warnaStatus(status: StatusResep): Color = when (status) {
    StatusResep.Diajukan -> Color(0xFFB26A00)
    StatusResep.Disetujui -> Color(0xFF2E7D32)
    StatusResep.Ditolak -> Color(0xFFC62828)
}
