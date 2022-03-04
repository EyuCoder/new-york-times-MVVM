package com.codexo.nyt.model.temp


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("abstract")
    val `abstract`: String? = null,
    @SerialName("adx_keywords")
    val adxKeywords: String? = null,
    @SerialName("asset_id")
    val assetId: Long? = null,
    @SerialName("byline")
    val byline: String? = null,
    @SerialName("column")
    val column: String? = null,
    @SerialName("des_facet")
    val desFacet: List<String>? = null,
    @SerialName("eta_id")
    val etaId: Int? = null,
    @SerialName("geo_facet")
    val geoFacet: List<String>? = null,
    @SerialName("id")
    val id: Long? = null,
    @SerialName("media")
    val media: List<Media>? = null,
    @SerialName("nytdsection")
    val nytdsection: String? = null,
    @SerialName("org_facet")
    val orgFacet: List<String>? = null,
    @SerialName("per_facet")
    val perFacet: List<String>? = null,
    @SerialName("published_date")
    val publishedDate: String? = null,
    @SerialName("section")
    val section: String? = null,
    @SerialName("source")
    val source: String? = null,
    @SerialName("subsection")
    val subsection: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("updated")
    val updated: String? = null,
    @SerialName("uri")
    val uri: String? = null,
    @SerialName("url")
    val url: String? = null
)