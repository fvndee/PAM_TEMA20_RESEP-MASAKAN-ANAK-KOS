package com.example.p5.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p5.data.PenyimpananResep
import com.example.p5.model.KategoriResep
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FormResepViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(FormResepUiState())
    val uiState: StateFlow<FormResepUiState> = _uiState.asStateFlow()

    fun ubahNama(teks: String) = _uiState.update { it.copy(nama = teks.take(40), pesan = null) }

    fun ubahDeskripsi(teks: String) = _uiState.update { it.copy(deskripsi = teks.take(80), pesan = null) }

    fun ubahBahan(teks: String) = _uiState.update { it.copy(bahan = teks, pesan = null) }

    fun ubahLangkah(teks: String) = _uiState.update { it.copy(langkah = teks, pesan = null) }

    fun ubahWaktuMasak(teks: String) = _uiState.update { it.copy(waktuMasak = hanyaAngka(teks, 3), pesan = null) }

    fun ubahEstimasiBiaya(teks: String) = _uiState.update { it.copy(estimasiBiaya = hanyaAngka(teks, 7), pesan = null) }

    fun ubahPorsi(teks: String) = _uiState.update { it.copy(porsi = hanyaAngka(teks, 2), pesan = null) }

    fun ubahAlatMasak(teks: String) = _uiState.update { it.copy(alatMasak = teks.take(30), pesan = null) }

    fun pilihKategori(kategori: KategoriResep) = _uiState.update { it.copy(kategori = kategori, pesan = null) }

    fun simpan() {
        val isian = _uiState.value
        if (!isian.bisaSimpan) return
        viewModelScope.launch {
            _uiState.update { it.copy(sedangMenyimpan = true) }
            delay(800)
            val idBaru = PenyimpananResep.tambah(
                nama = isian.nama.trim(),
                deskripsi = isian.deskripsi.trim(),
                bahan = isian.daftarBahan,
                langkah = isian.daftarLangkah,
                waktuMasakMenit = isian.waktuMasak.toInt(),
                estimasiBiaya = isian.estimasiBiaya.toInt(),
                porsi = isian.porsi.toInt(),
                alatMasak = isian.alatMasak.trim(),
                kategori = isian.kategori
            )
            _uiState.value = FormResepUiState(pesan = "Resep ${isian.nama.trim()} tersimpan", idTersimpan = idBaru)
        }
    }

    private fun hanyaAngka(teks: String, panjangMaksimal: Int) =
        teks.filter { it.isDigit() }.take(panjangMaksimal)
}
