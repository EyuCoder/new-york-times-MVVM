package com.codexo.nyt.data
import com.codexo.nyt.data.model.Results
import com.codexo.nyt.util.Constants
import retrofit2.http.GET

interface ArticleApi {
    @GET(Constants.END_POINT)
    suspend fun getArticle(): Results
}