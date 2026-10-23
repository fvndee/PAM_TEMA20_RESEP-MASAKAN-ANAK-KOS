package com.example.p3.data

import com.example.p3.model.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onStart

interface SumberResep {
    fun ambilSemua(): Flow<List<Resep>>
}

class SumberResepPalsu : SumberResep {
    private val hemat = KategoriResep(1, "Hemat Banget", "Di bawah Rp10.000")
    private val tanpaKompor = KategoriResep(2, "Tanpa Kompor", "Cukup rice cooker atau dispenser")

    private val data = MutableStateFlow(
        listOf(
            resep(1, "Nasi Goreng Telur", "Andalan akhir bulan", 10, 8000, hemat, StatusResep.Diajukan),
            resep(2, "Mie Rebus Spesial", "Mie instan plus sayur dan telur", 7, 6000, hemat, StatusResep.Disetujui),
            resep(3, "Nasi Telur Rice Cooker", "Masak nasi dan telur sekaligus", 25, 7000, tanpaKompor, StatusResep.Diajukan),
            resep(4, "Telur Orak-Arik Kecap", "Lauk cepat dengan bahan sederhana", 8, 5000, hemat, StatusResep.Disetujui),
            resep(5, "Oatmeal Pisang", "Sarapan praktis dan mengenyangkan", 5, 9000, tanpaKompor, StatusResep.Diajukan),
            resep(6, "Tumis Kangkung", "Sayur murah untuk makan siang", 12, 8000, hemat, StatusResep.Disetujui),
            resep(7, "Sarden Rice Cooker", "Menu gurih tanpa banyak alat", 20, 12000, tanpaKompor, StatusResep.Ditolak),
            resep(8, "Roti Telur Keju", "Camilan hangat anak kos", 10, 11000, hemat, StatusResep.Diajukan),
            resep(9, "Sup Sayur Sederhana", "Sup hangat dari bahan seadanya", 18, 10000, hemat, StatusResep.Disetujui),
            resep(10, "Bubur Ayam Rice Cooker", "Bubur lembut untuk sarapan", 35, 15000, tanpaKompor, StatusResep.Diajukan)
        )
    )

    private fun resep(
        id: Int, nama: String, deskripsi: String, waktu: Int, biaya: Int,
        kategori: KategoriResep, status: StatusResep
    ) = Resep(
        id, nama, deskripsi,
        listOf("Bahan utama", "Bumbu sederhana"),
        listOf("Siapkan bahan", "Masak hingga matang", "Sajikan"),
        waktu, biaya, 1, if (kategori == tanpaKompor) "Rice cooker" else "Penggorengan", kategori, status
    )

    override fun ambilSemua(): Flow<List<Resep>> = data.onStart { delay(500) }
}
