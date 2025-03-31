package me.grian.data.gathering

import kotlinx.serialization.Serializable

@Serializable
data class GatheringResponse(
    val data: GatheringData
)
