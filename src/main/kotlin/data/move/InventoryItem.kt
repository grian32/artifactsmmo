package me.grian.data.move

import kotlinx.serialization.Serializable

@Serializable
data class InventoryItem(
    val slot: Int,
    val code: String,
    val quantity: Int,
)
