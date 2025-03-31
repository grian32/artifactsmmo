package me.grian.commands.api

import io.ktor.client.HttpClient

abstract class Command (
    open val client: HttpClient,
    open val token: String,
    open val characterName: String
) {
    abstract val name: String

    abstract suspend fun execute(command: String)
}