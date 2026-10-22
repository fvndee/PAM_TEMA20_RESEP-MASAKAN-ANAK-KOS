package com.example.p2

class JVMPlatform: Platform {
    override val name: String = "Desktop (Java ${System.getProperty("java.version")})"
}

actual fun getPlatform(): Platform = JVMPlatform()