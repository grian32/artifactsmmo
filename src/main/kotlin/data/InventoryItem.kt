package me.grian.data

import kotlinx.serialization.Serializable

@Serializable
data class InventoryItem(
    val slot: Int,
    val code: String,
    val quantity: Int,
)