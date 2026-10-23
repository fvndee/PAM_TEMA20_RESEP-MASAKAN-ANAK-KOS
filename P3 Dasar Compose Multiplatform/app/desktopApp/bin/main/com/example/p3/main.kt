package com.example.p3

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "P3 - Resep Masakan Anak Kos",
    ) {
        App()
    }
}
