package me.grian.data

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val error: ErrorInfo
)
