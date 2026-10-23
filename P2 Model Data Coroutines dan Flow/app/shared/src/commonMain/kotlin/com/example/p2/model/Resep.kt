package com.example.p2.model

data class Resep(
    val id: Int,
    val nama: String,
    val deskripsi: String,
    val bahan: List<String>,
    val langkah: List<String>,
    val waktuMasakMenit: Int,
    val estimasiBiaya: Int,
    val porsi: Int,
    val alatMasak: String,
    val kategori: KategoriResep,
    val status: StatusResep,
    val fotoUrl: String? = null   // satu-satunya kolom nullable
)