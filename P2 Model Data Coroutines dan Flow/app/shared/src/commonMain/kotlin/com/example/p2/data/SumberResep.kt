package com.example.p2.data

import com.example.p2.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

interface SumberResep {
    fun ambilSemua(): Flow<List<Resep>>
    suspend fun ubahStatus(id: Int, statusBaru: StatusResep)
}

class SumberResepPalsu : SumberResep {
    private val hemat = KategoriResep(1, "Hemat Banget", "Di bawah Rp10.000")
    private val tanpaKompor = KategoriResep(2, "Tanpa Kompor", "Cukup rice cooker atau dispenser")

    private val data = MutableStateFlow(
        listOf(
            Resep(
                id = 1,
                nama = "Nasi Goreng Telur",
                deskripsi = "Andalan akhir bulan",
                bahan = listOf("Nasi", "Telur", "Kecap", "Bawang putih"),
                langkah = listOf("Tumis bawang", "Masukkan telur", "Masukkan nasi dan kecap"),
                waktuMasakMenit = 10,
                estimasiBiaya = 8000,
                porsi = 1,
                alatMasak = "Penggorengan",
                kategori = hemat,
                status = StatusResep.Diajukan
            ),
            Resep(
                id = 2,
                nama = "Mie Rebus Spesial",
                deskripsi = "Mie instan plus sayur dan telur",
                bahan = listOf("Mie instan", "Telur", "Sawi"),
                langkah = listOf("Rebus air", "Masukkan mie dan sayur", "Pecahkan telur"),
                waktuMasakMenit = 7,
                estimasiBiaya = 6000,
                porsi = 1,
                alatMasak = "Panci",
                kategori = hemat,
                status = StatusResep.Disetujui,
                fotoUrl = "https://contoh.com/mie.jpg"
            ),
            Resep(
                id = 3,
                nama = "Nasi Telur Rice Cooker",
                deskripsi = "Masak nasi dan telur sekaligus",
                bahan = listOf("Beras", "Telur", "Garam"),
                langkah = listOf("Masak beras", "Taruh telur di atas nasi saat setengah matang"),
                waktuMasakMenit = 25,
                estimasiBiaya = 7000,
                porsi = 1,
                alatMasak = "Rice cooker",
                kategori = tanpaKompor,
                status = StatusResep.Diajukan
            )
        )
    )

    override fun ambilSemua(): Flow<List<Resep>> =
        data.onStart { delay(1000) }   // simulasi delay jaringan

    override suspend fun ubahStatus(id: Int, statusBaru: StatusResep) {
        delay(500)
        data.update { daftar ->
            daftar.map { if (it.id == id) it.copy(status = statusBaru) else it }
        }
    }
}