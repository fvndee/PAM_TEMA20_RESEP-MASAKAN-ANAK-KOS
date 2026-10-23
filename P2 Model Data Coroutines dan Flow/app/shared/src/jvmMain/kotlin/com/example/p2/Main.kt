package com.example.p2

import com.example.p2.data.SumberResepPalsu
import com.example.p2.model.StatusResep
import com.example.p2.model.label
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val sumber = SumberResepPalsu()

    val pengamat = launch {
        sumber.ambilSemua().collect { daftar ->
            println("Daftar resep:")
            daftar.forEach { println("${it.nama}: ${it.status.label()}") }
        }
    }

    delay(1500)
    println("\nAdmin menyetujui Nasi Goreng Telur...")
    sumber.ubahStatus(1, StatusResep.Disetujui)
    delay(1000)
    pengamat.cancel()
    println("Selesai.")
}
