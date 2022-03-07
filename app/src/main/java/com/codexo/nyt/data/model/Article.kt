package com.codexo.nyt.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Article(
    val id: Long?,
    val url: String?,
    val source: String?,
    val updated: String?,
    val author: String?,
    val title: String?,
    val highlight: String?,
    val caption: String?,
    val copyright: String?,
    val photoUrl: String?
)