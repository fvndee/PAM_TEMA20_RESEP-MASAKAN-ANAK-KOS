package com.example.p2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform