package com.example.p4

class JVMPlatform: Platform {
    override val name: String = "Desktop (Java ${System.getProperty("java.version")})"
}

actual fun getPlatform(): Platform = JVMPlatform()