package me.grian.data.move

data class MoveData (
    val cooldown: Cooldown,
    val destination: Destination,
    val character: ArtifactsCharacter,
)
