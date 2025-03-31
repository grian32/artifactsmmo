package me.grian.commands

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import me.grian.actions.MoveAction
import me.grian.commands.api.Command
import me.grian.data.ErrorResponse
import me.grian.data.move.MoveResponse

class MoveCommand (
    override val client: HttpClient,
    override val token: String,
    override val characterName: String
) : Command(client, token, characterName) {
    override val name: String
        get() = "move"

    val action = MoveAction(
        client,
        token,
        characterName
    )

    override suspend fun execute(command: String) {
        val xAndY = command.trim().split(" ").drop(1).map(String::toInt)

        val x = xAndY[0]
        val y = xAndY[1]

        val response = action.move(x, y)

        when (response.status) {
            HttpStatusCode.Companion.OK -> {
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