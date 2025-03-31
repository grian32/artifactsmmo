package me.grian.actions

import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse

data class GatheringAction(
    private val client: HttpClient,
    private val token: String,
    private val characterName: String
) {
    private fun endpoint(name: String): String = "https://api.artifactsmmo.com/my/$name/action/gathering"

    suspend fun gather(): HttpResponse {
        val request = client.post(endpoint(characterName)) {
            headers {
                set("Content-Type", "application/json")
                set("Accept", "application/json")
                set("Authorization", "Bearer $token")
            }
        }

        return request
    }
}
