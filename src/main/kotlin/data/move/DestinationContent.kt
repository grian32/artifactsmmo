package me.grian.data.move

import kotlinx.serialization.Serializable

@Serializable
data class DestinationContent(
    val type: String,
    val code: String,
)
