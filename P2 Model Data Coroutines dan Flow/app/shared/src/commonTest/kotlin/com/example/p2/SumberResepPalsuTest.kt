package com.example.p2

import com.example.p2.data.SumberResepPalsu
import com.example.p2.model.StatusResep
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class SumberResepPalsuTest {

    @Test
    fun testAmbilSemuaDanUbahStatus() = runBlocking {
        val sumber = SumberResepPalsu()
        
        var resepList = sumber.ambilSemua().first()
        val nasiGoreng = resepList.first { it.id == 1 }
        assertEquals(StatusResep.Diajukan, nasiGoreng.status)

        sumber.ubahStatus(1, StatusResep.Disetujui)

        resepList = sumber.ambilSemua().first()
        val nasiGorengBaru = resepList.first { it.id == 1 }
        assertEquals(StatusResep.Disetujui, nasiGorengBaru.status)
    }
}
