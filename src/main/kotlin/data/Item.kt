package me.grian.data

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val code: String,
    val quantity: Int
)
