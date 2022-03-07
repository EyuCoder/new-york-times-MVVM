package com.codexo.nyt.data

import com.codexo.nyt.data.ArticleApi
import com.codexo.nyt.data.model.Article
import com.codexo.nyt.data.model.asArticleModel
import javax.inject.Inject

class ArticleRepo @Inject constructor(private val articleApi: ArticleApi) {
    suspend fun getArticles(): List<Article> {
        return articleApi.getArticle().asArticleModel()
    }
}