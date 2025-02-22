package me.grian

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import me.grian.actions.MoveAction
import me.grian.data.ErrorResponse
import me.grian.data.move.MoveResponse
import java.util.Scanner
import kotlin.io.path.Path
import kotlin.io.path.readText

suspend fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json)
        }
    }

    val env = Json.decodeFromString<Env>(Path("src/main/resources/env.json").readText())

    val characterName = "Grian"

    val moveAction = MoveAction(
        client,
        env.token,
        characterName
    )

    val sc = Scanner(System.`in`)

    while (sc.hasNextLine()) {
        val command = sc.nextLine()

        when {
            // TODO: refactor this as its a very basic cmd system rn.
            command.startsWith("move") -> {
                val xAndY = command.trim().split(" ").drop(1).map(String::toInt)

                val x = xAndY[0]
                val y = xAndY[1]

                val response = moveAction.move(x, y)

                when (response.status) {
                    HttpStatusCode.OK -> {
                        val body = response.body<MoveResponse>()

                        if (body.data.destination.x == x && body.data.destination.y == y) {
                            println("Successfully moved to square (${x}, ${y})")
                        } else {
                            println("Something went wrong when trying to move to square (${x}, ${y})")
                        }
                    }
                    else -> {
                        try {
                            val body = response.body<ErrorResponse>()
                            println("Could not move due to the following reason: ${body.error.message}")
                        } catch (e: Exception) {
                            println("Something went wrong: ${e.message}")
                        }
                    }
                }
            }
        }
    }
}