package com.example.p4.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4.data.daftarKategori
import com.example.p4.model.KategoriResep

@Composable
fun FormResepScreen(
    kembali: () -> Unit,
    vm: FormResepViewModel = viewModel { FormResepViewModel() }
) {
    val state by vm.uiState.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextButton(onClick = kembali) { Text("Kembali ke daftar") }
        Text("Resep baru", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        KolomTeks(
            label = "Nama resep",
            value = state.nama,
            onValueChange = vm::ubahNama,
            keterangan = if (state.namaTerlaluPendek) "Minimal 3 huruf" else "${state.nama.length} dari 40 karakter",
            salah = state.namaTerlaluPendek
        )
        KolomTeks("Deskripsi singkat", state.deskripsi, vm::ubahDeskripsi)
        KolomTeks(
            label = "Bahan",
            value = state.bahan,
            onValueChange = vm::ubahBahan,
            keterangan = "Pisahkan dengan koma, terbaca ${state.daftarBahan.size} bahan"
        )
        KolomTeks(
            label = "Langkah memasak",
            value = state.langkah,
            onValueChange = vm::ubahLangkah,
            keterangan = "Satu langkah per baris, terbaca ${state.daftarLangkah.size} langkah",
            barisBanyak = true
        )
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Column(Modifier.weight(1f)) {
                KolomTeks("Menit", state.waktuMasak, vm::ubahWaktuMasak, angka = true)
            }
            Column(Modifier.weight(1f)) {
                KolomTeks("Porsi", state.porsi, vm::ubahPorsi, angka = true)
            }
        }
        KolomTeks(
            label = "Estimasi biaya",
            value = state.estimasiBiaya,
            onValueChange = vm::ubahEstimasiBiaya,
            keterangan = state.estimasiBiaya.toIntOrNull()?.let { formatRupiah(it) },
            angka = true
        )
        KolomTeks("Alat masak", state.alatMasak, vm::ubahAlatMasak)
        Text("Kategori", style = MaterialTheme.typography.titleSmall)
        PilihanKategori(daftarKategori, state.kategori, vm::pilihKategori)
        Button(
            onClick = vm::simpan,
            enabled = state.bisaSimpan,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(if (state.sedangMenyimpan) "Menyimpan" else "Simpan resep")
        }
        state.pesan?.let { Text(it, color = Color(0xFF2E7D32)) }
    }
}

@Composable
fun PilihanKategori(
    semua: List<KategoriResep>,
    terpilih: KategoriResep,
    onPilih: (KategoriResep) -> Unit
) {
    Column {
        semua.forEach { kategori ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = kategori == terpilih,
                        onClick = { onPilih(kategori) },
                        role = Role.RadioButton
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = kategori == terpilih, onClick = null)
                Column(Modifier.padding(start = 8.dp)) {
                    Text(kategori.nama)
                    Text(kategori.deskripsi, fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
    }
}
