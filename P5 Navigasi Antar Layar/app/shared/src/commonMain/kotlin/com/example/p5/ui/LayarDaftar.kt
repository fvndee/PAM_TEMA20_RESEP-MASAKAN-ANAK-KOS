package com.example.p5.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p5.model.Resep
import com.example.p5.model.StatusResep
import org.jetbrains.compose.resources.painterResource
import p5.app.shared.generated.resources.Res
import p5.app.shared.generated.resources.ic_tambah

@Composable
fun LayarDaftar(
    semua: List<Resep>,
    bukaDetail: (Int) -> Unit,
    bukaForm: () -> Unit
) {
    val terbaru = semua.sortedByDescending { it.id }
    val disetujui = semua.count { it.status is StatusResep.Disetujui }
    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        floatingActionButton = {
            FloatingActionButton(onClick = bukaForm) {
                Icon(painterResource(Res.drawable.ic_tambah), contentDescription = "Tambah resep")
            }
        }
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            Column(Modifier.padding(16.dp)) {
                Text("Resep Anak Kos", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Text("$disetujui dari ${semua.size} resep sudah disetujui", color = Color.Gray)
                Text("Resep terbaru di paling atas", fontSize = 13.sp, color = Color.Gray)
            }
            DaftarResep(semua = terbaru, onPilih = { bukaDetail(it.id) })
        }
    }
}
