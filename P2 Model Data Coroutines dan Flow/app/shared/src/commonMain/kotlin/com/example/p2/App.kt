package com.example.p2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.p2.data.SumberResepPalsu
import com.example.p2.model.StatusResep
import kotlinx.coroutines.launch

fun namaStatus(s: StatusResep) = when (s) {
    StatusResep.Diajukan -> "Diajukan"
    StatusResep.Disetujui -> "Disetujui"
    StatusResep.Ditolak -> "Ditolak"
}

@Composable
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val sumberResep = remember { SumberResepPalsu() }
            val resepList by sumberResep.ambilSemua().collectAsState(initial = emptyList())
            val coroutineScope = rememberCoroutineScope()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Resep Masakan Anak Kos",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                if (resepList.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(resepList, key = { it.id }) { resep ->
                            Card(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Text(
                                        text = resep.nama,
                                        style = MaterialTheme.typography.titleLarge
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = resep.deskripsi,
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Kategori: ${resep.kategori.nama}",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Text(
                                        text = "Estimasi Biaya: Rp${resep.estimasiBiaya}",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Text(
                                        text = "Status: ${namaStatus(resep.status)}",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    if (resep.status is StatusResep.Diajukan) {
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Button(
                                            onClick = {
                                                coroutineScope.launch {
                                                    sumberResep.ubahStatus(resep.id, StatusResep.Disetujui)
                                                }
                                            }
                                        ) {
                                            Text("Setujui Resep")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


