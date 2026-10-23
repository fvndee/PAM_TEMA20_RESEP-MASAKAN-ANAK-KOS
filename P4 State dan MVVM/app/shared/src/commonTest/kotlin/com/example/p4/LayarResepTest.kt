package com.example.p4

import com.example.p4.data.PenyimpananResep
import com.example.p4.data.daftarKategori
import com.example.p4.data.resepContoh
import com.example.p4.model.StatusResep
import com.example.p4.ui.FormResepUiState
import com.example.p4.ui.formatRupiah
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LayarResepTest {

    private val isianLengkap = FormResepUiState(
        nama = "Telur Ceplok Kecap",
        deskripsi = "Lauk lima menit",
        bahan = "Telur, Kecap, Minyak",
        langkah = "Panaskan minyak\nCeplok telur\nSiram kecap",
        waktuMasak = "5",
        estimasiBiaya = "4000",
        porsi = "1",
        alatMasak = "Teflon"
    )

    @Test
    fun formatRupiahMemakaiTitikRibuan() {
        assertEquals("Rp500", formatRupiah(500))
        assertEquals("Rp8.000", formatRupiah(8000))
        assertEquals("Rp1.250.000", formatRupiah(1250000))
    }

    @Test
    fun dataContohPunyaMinimalSepuluhResep() {
        assertTrue(resepContoh.size >= 10)
        assertEquals(resepContoh.size, resepContoh.map { it.id }.toSet().size)
    }

    @Test
    fun formLengkapBisaDisimpan() {
        assertTrue(isianLengkap.bisaSimpan)
        assertEquals(listOf("Telur", "Kecap", "Minyak"), isianLengkap.daftarBahan)
        assertEquals(3, isianLengkap.daftarLangkah.size)
    }

    @Test
    fun formTidakBisaDisimpanKalauAdaYangKurang() {
        assertFalse(FormResepUiState().bisaSimpan)
        assertFalse(isianLengkap.copy(nama = "Te").bisaSimpan)
        assertTrue(isianLengkap.copy(nama = "Te").namaTerlaluPendek)
        assertFalse(isianLengkap.copy(bahan = " , ").bisaSimpan)
        assertFalse(isianLengkap.copy(estimasiBiaya = "0").bisaSimpan)
        assertFalse(isianLengkap.copy(sedangMenyimpan = true).bisaSimpan)
    }

    @Test
    fun resepBaruMasukPenyimpananDenganStatusDiajukan() {
        val jumlahAwal = PenyimpananResep.daftar.value.size
        val id = PenyimpananResep.tambah(
            nama = "Telur Ceplok Kecap",
            deskripsi = "Lauk lima menit",
            bahan = listOf("Telur", "Kecap"),
            langkah = listOf("Ceplok telur", "Siram kecap"),
            waktuMasakMenit = 5,
            estimasiBiaya = 4000,
            porsi = 1,
            alatMasak = "Teflon",
            kategori = daftarKategori.first()
        )
        val semua = PenyimpananResep.daftar.value
        assertEquals(jumlahAwal + 1, semua.size)
        assertEquals(StatusResep.Diajukan, semua.first { it.id == id }.status)
    }
}
