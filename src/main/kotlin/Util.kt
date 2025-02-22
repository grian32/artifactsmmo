package me.grian

import io.ktor.http.*

fun HeadersBuilder.applyBasicHeaders(token: String) = HeadersBuilder().apply {
    set("Content-Type", "application/json")
    set("Accept", "application/json")
    set("Authorization", "Bearer $token")
}