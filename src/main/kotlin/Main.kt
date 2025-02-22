package me.grian

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json)
        }
    }
}