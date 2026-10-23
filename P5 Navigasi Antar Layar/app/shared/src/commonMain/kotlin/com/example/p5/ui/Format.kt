package com.example.p5.ui

fun formatRupiah(nilai: Int): String {
    val angka = nilai.toString().reversed().chunked(3).joinToString(".").reversed()
    return "Rp$angka"
}
