package com.codexo.nyt.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codexo.nyt.model.Article
import com.codexo.nyt.repository.ArticleRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val articleRepo: ArticleRepo
) : ViewModel() {

    private val _state = MutableStateFlow(emptyList<Article>())
    val state: StateFlow<List<Article>>
        get() = _state

    init {

        viewModelScope.launch {
            val articles = articleRepo.getArticles()
            _state.value = articles
        }
    }
}