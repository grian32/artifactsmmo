package me.grian.data.move

import kotlinx.serialization.Serializable

@Serializable
data class MoveData (
    val cooldown: Cooldown,
    val destination: Destination,
    val character: ArtifactsCharacter,
)
