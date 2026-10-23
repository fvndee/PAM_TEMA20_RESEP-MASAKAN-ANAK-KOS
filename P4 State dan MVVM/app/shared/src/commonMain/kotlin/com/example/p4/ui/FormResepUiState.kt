package com.example.p4.ui

import com.example.p4.data.daftarKategori
import com.example.p4.model.KategoriResep

data class FormResepUiState(
    val nama: String = "",
    val deskripsi: String = "",
    val bahan: String = "",
    val langkah: String = "",
    val waktuMasak: String = "",
    val estimasiBiaya: String = "",
    val porsi: String = "1",
    val alatMasak: String = "",
    val kategori: KategoriResep = daftarKategori.first(),
    val sedangMenyimpan: Boolean = false,
    val pesan: String? = null
) {
    val daftarBahan: List<String>
        get() = bahan.split(",").map { it.trim() }.filter { it.isNotEmpty() }

    val daftarLangkah: List<String>
        get() = langkah.lines().map { it.trim() }.filter { it.isNotEmpty() }

    val namaTerlaluPendek: Boolean
        get() = nama.isNotEmpty() && nama.trim().length < 3

    val bisaSimpan: Boolean
        get() = nama.trim().length >= 3 &&
            deskripsi.isNotBlank() &&
            daftarBahan.isNotEmpty() &&
            daftarLangkah.isNotEmpty() &&
            (waktuMasak.toIntOrNull() ?: 0) > 0 &&
            (estimasiBiaya.toIntOrNull() ?: 0) > 0 &&
            (porsi.toIntOrNull() ?: 0) > 0 &&
            alatMasak.isNotBlank() &&
            !sedangMenyimpan
}
