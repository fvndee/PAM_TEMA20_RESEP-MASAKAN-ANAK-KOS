package com.example.p4.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.p4.model.Resep

@Composable
fun KartuResep(
    resep: Resep,
    ringkas: Boolean = false,
    onKlik: () -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onKlik() },
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        if (!ringkas) FotoResep(resep)
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = resep.nama,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Text(formatRupiah(resep.estimasiBiaya), fontWeight = FontWeight.Bold)
            }
            Text(
                text = resep.deskripsi,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            if (ringkas) {
                LabelStatus(resep.status)
            } else {
                BarisInfo(resep.kategori.nama, resep.alatMasak, resep.waktuMasakMenit)
            }
        }
    }
}
