package me.grian.data.gathering

import kotlinx.serialization.Serializable
import me.grian.data.ArtifactsCharacter
import me.grian.data.Cooldown

@Serializable
data class GatheringData(
    val cooldown: Cooldown,
    val details: GatheringDetails,
    val character: ArtifactsCharacter
)