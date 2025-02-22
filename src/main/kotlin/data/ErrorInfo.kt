package me.grian.data

import kotlinx.serialization.Serializable

@Serializable
data class ErrorInfo(
    val code: Int,
    val message: String,
)
