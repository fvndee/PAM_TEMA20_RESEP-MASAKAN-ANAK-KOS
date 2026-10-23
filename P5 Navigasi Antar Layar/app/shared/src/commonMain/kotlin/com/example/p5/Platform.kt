package com.example.p5

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform