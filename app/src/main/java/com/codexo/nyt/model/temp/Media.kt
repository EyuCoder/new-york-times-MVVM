package com.codexo.nyt.model.temp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Media(
    @SerialName("approved_for_syndication")
    val approvedForSyndication: Int? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("copyright")
    val copyright: String? = null,
    @SerialName("media-metadata")
    val mediaMetadata: List<MediaMetadata>? = null,
    @SerialName("subtype")
    val subtype: String? = null,
    @SerialName("type")
    val type: String? = null
)