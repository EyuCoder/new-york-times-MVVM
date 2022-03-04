package com.codexo.nyt.repository

import com.codexo.nyt.ArticleApi
import com.codexo.nyt.model.Article
import com.codexo.nyt.model.asArticleModel
import javax.inject.Inject

class ArticleRepo @Inject constructor(private val articleApi: ArticleApi) {
    suspend fun getArticles(): List<Article> {
        return articleApi.getArticle().asArticleModel()
    }
}