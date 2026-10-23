package com.example.p5.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p5.model.StatusResep
import com.example.p5.model.label

@Composable
fun LabelStatus(status: StatusResep, modifier: Modifier = Modifier) {
    val warna = when (status) {
        StatusResep.Diajukan -> Color(0xFFF6EDCF)
        StatusResep.Disetujui -> Color(0xFFDCEFD6)
        StatusResep.Ditolak -> Color(0xFFF4D9D6)
    }
    Text(
        text = status.label(),
        fontSize = 12.sp,
        modifier = modifier
            .background(warna, RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    )
}
