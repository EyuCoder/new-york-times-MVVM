package com.codexo.nyt.model.temp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaMetadata(
    @SerialName("format")
    val format: String? = null,
    @SerialName("height")
    val height: Int? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("width")
    val width: Int? = null
)