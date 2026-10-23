package com.example.p5.nav

import org.jetbrains.compose.resources.DrawableResource
import p5.app.shared.generated.resources.Res
import p5.app.shared.generated.resources.ic_asisten
import p5.app.shared.generated.resources.ic_beranda
import p5.app.shared.generated.resources.ic_profil

data class Tab(val label: String, val ikon: DrawableResource, val rute: Any)

val daftarTab = listOf(
    Tab("Beranda", Res.drawable.ic_beranda, RuteBeranda),
    Tab("Asisten", Res.drawable.ic_asisten, RuteAsisten),
    Tab("Profil", Res.drawable.ic_profil, RuteProfil)
)
