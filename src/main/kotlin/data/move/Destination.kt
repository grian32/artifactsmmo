package me.grian.data.move

import kotlinx.serialization.Serializable

@Serializable
data class Destination(
    val name: String,
    val skin: String,
    val x: Int,
    val y: Int,
    val content: DestinationContent,
)
