package com.example.p4

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.p4.data.PenyimpananResep
import com.example.p4.ui.FormResepScreen
import com.example.p4.ui.LayarUtama

@Composable
fun App() {
    MaterialTheme {
        var diForm by rememberSaveable { mutableStateOf(false) }
        val daftar by PenyimpananResep.daftar.collectAsState()
        if (diForm) {
            FormResepScreen(kembali = { diForm = false })
        } else {
            LayarUtama(
                semua = daftar,
                onPilih = { println("Dipilih: ${it.nama}") },
                onTambah = { diForm = true }
            )
        }
    }
}
