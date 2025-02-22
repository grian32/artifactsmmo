package me.grian.data.move

import kotlinx.serialization.Serializable

@Serializable
data class MoveResponse(
    val data: MoveData
)