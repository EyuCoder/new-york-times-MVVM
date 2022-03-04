package com.codexo.nyt.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.codexo.nyt.model.temp.Result

@Serializable
data class ArticleContainer(
    @SerialName("copyright")
    val copyright: String,
    @SerialName("num_results")
    val numResults: Int, // 20
    @SerialName("results")
    val results: List<Result>,
    @SerialName("status")
    val status: String // OK
)

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

fun ArticleContainer.asArticleModel(): List<Article> {
    return results.map {
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