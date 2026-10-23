package com.example.p5

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Resep Anak Kos",
    ) {
        App()
    }
}