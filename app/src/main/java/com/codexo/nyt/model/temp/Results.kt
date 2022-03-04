package com.codexo.nyt.model.temp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Results(
    @SerialName("copyright")
    val copyright: String? = null,
    @SerialName("num_results")
    val numResults: Int? = null,
    @SerialName("results")
    val results: List<Result>? = null,
    @SerialName("status")
    val status: String? = null
)