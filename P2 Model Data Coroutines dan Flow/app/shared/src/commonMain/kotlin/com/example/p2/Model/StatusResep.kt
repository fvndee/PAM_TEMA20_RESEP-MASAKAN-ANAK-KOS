package com.example.p2.model

sealed class StatusResep {
    data object Diajukan : StatusResep()
    data object Disetujui : StatusResep()
    data object Ditolak : StatusResep()
}
