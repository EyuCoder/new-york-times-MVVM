package com.codexo.nyt
import com.codexo.nyt.model.Results
import com.codexo.nyt.util.Constants
import retrofit2.http.GET

interface ArticleApi {
    @GET(Constants.END_POINT)
    suspend fun getArticle(): Results
}