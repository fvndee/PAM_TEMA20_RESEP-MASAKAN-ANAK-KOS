package com.example.p4

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform