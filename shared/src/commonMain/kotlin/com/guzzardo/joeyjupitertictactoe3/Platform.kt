package com.guzzardo.joeyjupitertictactoe3

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform