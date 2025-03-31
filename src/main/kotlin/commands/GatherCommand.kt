package me.grian.commands

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode
import me.grian.actions.GatheringAction
import me.grian.actions.MoveAction
import me.grian.commands.api.Command
import me.grian.data.ErrorResponse
import me.grian.data.gathering.GatheringData
import me.grian.data.gathering.GatheringResponse
import me.grian.data.move.MoveResponse

class GatherCommand (
    override val client: HttpClient,
    override val token: String,
    override val characterName: String
) : Command(client, token, characterName) {
    override val name: String
        get() = "gather"

    val action = GatheringAction(
        client,
        token,
        characterName
    )

    override suspend fun execute(command: String) {
        val response = action.gather()

        when (response.status) {
            HttpStatusCode.Companion.OK -> {
                val body = response.body<GatheringResponse>()

                val itemsString = body.data.details.items.map {
                    "${it.quantity}x ${it.code}; "
                }

                val currentInventoryString = body.data.character.inventory.map {
                    "${it.quantity}x ${it.code} & ${it.slot}; "
                }


                // TODO: added to inv condition i guess
                if (true) {
                    println("Successfully gathered: $itemsString\n\n Current Inventory: $currentInventoryString")
                } else {
                    println("Something went wrong when trying to gather")
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