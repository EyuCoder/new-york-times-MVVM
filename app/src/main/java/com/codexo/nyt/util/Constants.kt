package com.codexo.nyt.util

import com.codexo.nyt.BuildConfig

object Constants {
    const val API_KEY = BuildConfig.API_KEY
    const val BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/"
    const val END_POINT = "emailed/7.json?api-key=$API_KEY"
}