package com.example.p5.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p5.data.PenyimpananResep
import com.example.p5.model.Resep
import com.example.p5.model.StatusResep
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

sealed class DetailUiState {
    data object Memuat : DetailUiState()
    data class Ada(val resep: Resep) : DetailUiState()
    data object TidakDitemukan : DetailUiState()
}

class DetailViewModel(private val id: Int) : ViewModel() {
    val uiState: StateFlow<DetailUiState> = PenyimpananResep.daftar
        .map { semua ->
            val resep = semua.find { it.id == id }
            if (resep == null) DetailUiState.TidakDitemukan else DetailUiState.Ada(resep)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), DetailUiState.Memuat)

    fun setujui() = PenyimpananResep.ubahStatus(id, StatusResep.Disetujui)

    fun tolak() = PenyimpananResep.ubahStatus(id, StatusResep.Ditolak)
}
