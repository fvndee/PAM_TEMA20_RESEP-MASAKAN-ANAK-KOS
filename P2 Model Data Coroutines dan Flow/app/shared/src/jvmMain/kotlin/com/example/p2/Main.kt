package com.example.p2

import com.example.p2.data.SumberResepPalsu
import com.example.p2.model.StatusResep
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val sumber = SumberResepPalsu()

    launch {
        sumber.ambilSemua().collect { daftar ->
            println("--- Daftar resep ---")
            daftar.forEach { println("${it.nama}: ${namaStatus(it.status)}") }
        }
    }

    delay(1500)
    println("\nAdmin menyetujui Nasi Goreng Telur...")
    sumber.ubahStatus(1, StatusResep.Disetujui)
    delay(1000)
    println("Selesai.")
}
