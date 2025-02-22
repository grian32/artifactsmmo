package me.grian.data.move

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cooldown( 
    @SerialName("total_seconds")
    val totalSeconds: Long,
    @SerialName("remaining_seconds")
    val remainingSeconds: Long,
    @SerialName("started_at")
    val startedAt: String,
    val expiration: String,
    val reason: String, 
)
