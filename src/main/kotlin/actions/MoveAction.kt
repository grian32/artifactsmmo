package me.grian.actions

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import me.grian.applyBasicHeaders
import me.grian.data.move.MoveRequest
import me.grian.data.move.MoveResponse

class MoveAction(
    private val client: HttpClient,
    private val token: String,
    private val characterName: String
) {
    private fun endpoint(name: String): String = "https://api.artifactsmmo.com/my/$name/action/move"

    suspend fun move(x: Int, y: Int): MoveResponse {
        val requestBody =  MoveRequest(
            x,
            y
        )

        val request = client.post(endpoint(characterName)) {
            headers {
                set("Content-Type", "application/json")
                set("Accept", "application/json")
                set("Authorization", "Bearer $token")
            }

            setBody(requestBody)
        }

        return request.body<MoveResponse>()
    }
}
