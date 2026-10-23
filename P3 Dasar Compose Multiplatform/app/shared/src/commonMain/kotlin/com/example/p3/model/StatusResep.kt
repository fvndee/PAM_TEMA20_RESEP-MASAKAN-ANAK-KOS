package com.example.p3.model

sealed class StatusResep {
    data object Diajukan : StatusResep()
    data object Disetujui : StatusResep()
    data object Ditolak : StatusResep()
}

fun StatusResep.label(): String = when (this) {
    StatusResep.Diajukan -> "Diajukan"
    StatusResep.Disetujui -> "Disetujui"
    StatusResep.Ditolak -> "Ditolak"
}
