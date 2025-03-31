package me.grian.data.move

import kotlinx.serialization.Serializable
import me.grian.data.ArtifactsCharacter
import me.grian.data.Cooldown

@Serializable
data class MoveData (
    val cooldown: Cooldown,
    val destination: Destination,
    val character: ArtifactsCharacter,
)
