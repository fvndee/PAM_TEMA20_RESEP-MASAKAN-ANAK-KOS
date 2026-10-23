package com.example.p4.data

import com.example.p4.model.KategoriResep
import com.example.p4.model.Resep
import com.example.p4.model.StatusResep
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object PenyimpananResep {
    private val _daftar = MutableStateFlow(resepContoh)
    val daftar: StateFlow<List<Resep>> = _daftar.asStateFlow()

    fun tambah(
        nama: String,
        deskripsi: String,
        bahan: List<String>,
        langkah: List<String>,
        waktuMasakMenit: Int,
        estimasiBiaya: Int,
        porsi: Int,
        alatMasak: String,
        kategori: KategoriResep
    ): Int {
        var idBaru = 0
        _daftar.update { lama ->
            idBaru = (lama.maxOfOrNull { it.id } ?: 0) + 1
            lama + Resep(
                id = idBaru,
                nama = nama,
                deskripsi = deskripsi,
                bahan = bahan,
                langkah = langkah,
                waktuMasakMenit = waktuMasakMenit,
                estimasiBiaya = estimasiBiaya,
                porsi = porsi,
                alatMasak = alatMasak,
                kategori = kategori,
                status = StatusResep.Diajukan
            )
        }
        return idBaru
    }

    fun ubahStatus(id: Int, statusBaru: StatusResep) = _daftar.update { daftar ->
        daftar.map { if (it.id == id) it.copy(status = statusBaru) else it }
    }
}
