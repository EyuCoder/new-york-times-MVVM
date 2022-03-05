package com.codexo.nyt.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Results(
    val results: List<Result>? = null
)


@Serializable
data class Result(
    @SerialName("abstract")
    val `abstract`: String? = null,
    @SerialName("asset_id")
    val assetId: Long? = null,
    val byline: String? = null,
    val id: Long? = null,
    val media: List<Media>? = null,
    @SerialName("published_date")
    val publishedDate: String? = null,
    val source: String? = null,
    val title: String? = null,
    val updated: String? = null,
    val url: String? = null
)

@Serializable
data class Media(
    val caption: String? = null,
    val copyright: String? = null,
    @SerialName("media-metadata")
    val mediaMetadata: List<MediaMetadata>? = null
)

@Serializable
data class MediaMetadata(
    val url: String? = null
)

fun Results.asArticleModel(): List<Article> {
    return results!!.map {
        Article(
            id = it.id,
            url = it.url,
            source = it.source,
            updated = it.updated,
            author = it.byline,
            title = it.title,
            highlight = it.abstract,
            caption = it.media?.get(0)?.caption,
            copyright = it.media?.get(0)?.copyright,
            photoUrl = it.media?.get(0)?.mediaMetadata?.get(2)?.url
        )
    }
}