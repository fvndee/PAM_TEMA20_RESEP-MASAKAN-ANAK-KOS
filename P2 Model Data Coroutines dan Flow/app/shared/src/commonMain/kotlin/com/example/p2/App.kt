package com.example.p2

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p2.data.SumberResepPalsu
import com.example.p2.model.Resep
import com.example.p2.model.StatusResep
import com.example.p2.model.label
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {
    MaterialTheme {
        val sumber = remember { SumberResepPalsu() }
        val aliran = remember { sumber.ambilSemua() }
        val daftar by aliran.collectAsState(initial = null)   // null = masih loading
        val scope = rememberCoroutineScope()
        var tampilkanKelompok by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize()
        ) {
            Text(
                "Resep Masakan Anak Kos",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(8.dp))

            Button(onClick = { tampilkanKelompok = !tampilkanKelompok }) {
                Text("Tentang kelompok")
            }
            AnimatedVisibility(tampilkanKelompok) {
                Column(Modifier.padding(vertical = 8.dp)) {
                    Text("Nama Anggota Kelompok 6:")
                    Text("Hanung Akbar Pramusintho (124140207)")
                    Text("Rajendra Rifandy (124140099)")
                    Text("Firman Luthfiansyah (124140044)")
                    Text("Platform: ${getPlatform().name}")
                }
            }

            Spacer(Modifier.height(8.dp))

            val resepList = daftar
            if (resepList == null) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(resepList, key = { it.id }) { resep ->
                        KartuResep(
                            resep = resep,
                            onSetujui = {
                                scope.launch { sumber.ubahStatus(resep.id, StatusResep.Disetujui) }
                            },
                            onTolak = {
                                scope.launch { sumber.ubahStatus(resep.id, StatusResep.Ditolak) }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun KartuResep(
    resep: Resep,
    onSetujui: () -> Unit,
    onTolak: () -> Unit
) {
    var detail by remember { mutableStateOf(false) }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    resep.nama,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    resep.status.label(),
                    color = warnaStatus(resep.status),
                    fontWeight = FontWeight.SemiBold
                )
            }

            Text(resep.deskripsi, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(4.dp))
            Text(
                "${resep.kategori.nama} • ${resep.waktuMasakMenit} menit • " +
                        "Rp${resep.estimasiBiaya} • ${resep.porsi} porsi",
                style = MaterialTheme.typography.bodySmall
            )
            Text("Alat: ${resep.alatMasak}", style = MaterialTheme.typography.bodySmall)
            Text(
                if (resep.fotoUrl != null) "Foto: tersedia" else "Foto: belum ada",
                style = MaterialTheme.typography.bodySmall
            )

            AnimatedVisibility(detail) {
                Column(Modifier.padding(top = 8.dp)) {
                    Text("Bahan:", fontWeight = FontWeight.SemiBold)
                    resep.bahan.forEach { Text("• $it") }
                    Spacer(Modifier.height(4.dp))
                    Text("Langkah:", fontWeight = FontWeight.SemiBold)
                    resep.langkah.forEachIndexed { i, l -> Text("${i + 1}. $l") }
                }
            }

            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TextButton(onClick = { detail = !detail }) {
                    Text(if (detail) "Sembunyikan" else "Lihat detail")
                }
                if (resep.status == StatusResep.Diajukan) {
                    Button(onClick = onSetujui) { Text("Setujui") }
                    OutlinedButton(onClick = onTolak) { Text("Tolak") }
                }
            }
        }
    }
}

private fun warnaStatus(status: StatusResep): Color = when (status) {
    StatusResep.Diajukan -> Color(0xFFB26A00)
    StatusResep.Disetujui -> Color(0xFF2E7D32)
    StatusResep.Ditolak -> Color(0xFFC62828)
}