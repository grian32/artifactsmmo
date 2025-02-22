package me.grian

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.io.path.Path
import kotlin.io.path.readText

fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json)
        }
    }

    val env = Json.decodeFromString<Env>(Path("src/main/resources/env.json").readText())

    val headers = HeadersBuilder().apply {
        set("Content-Type", "application/json")
        set("Accept", "application/json")
        set("Authorization", "Bearer ${env.token}")
    }

    val characterName = "Grian"
}