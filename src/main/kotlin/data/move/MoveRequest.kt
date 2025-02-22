package me.grian.data.move

import kotlinx.serialization.Serializable

@Serializable
data class MoveRequest(
    val x: Int,
    val y: Int
)
