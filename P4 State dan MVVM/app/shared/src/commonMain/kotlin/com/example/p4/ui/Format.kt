package com.example.p4.ui

fun formatRupiah(nilai: Int): String {
    val angka = nilai.toString().reversed().chunked(3).joinToString(".").reversed()
    return "Rp$angka"
}
