package me.grian.data.gathering

import kotlinx.serialization.Serializable
import me.grian.data.Item

@Serializable
data class GatheringDetails(
    val xp: Int,
    val items: List<Item>
)
