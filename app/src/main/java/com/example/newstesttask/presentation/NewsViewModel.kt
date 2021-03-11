package com.example.newstesttask.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newstesttask.data.repository.NewsRepository
import com.example.newstesttask.domain.entity.Article

/**
* Viewmodel, ответственная за master-detail flow для
 * NewsFeedFragment и ArticleFragment
* */
class NewsViewModel: ViewModel() {

    // Список новостей
    val news = MutableLiveData<List<Article>>()

    // Выбранная новость
    val selectedArticle = MutableLiveData<Article>()

    // Сохранение позиции скролла
    // у ScrollView в ArticleFragment
    var scrollPosition = 0

    // Репозиторий новостей (источник данных может быть любой)
    private val repository = NewsRepository()

    // Получение новости из репозитория и отправка в liveData,
    // благодаря чему observer сразу получит новости
    fun getNews() {
        this.news.value = repository.getNews()
    }

    // Устанавливаем выбранный фрагмент,
    // который будет открыт в ArticleFragment
    fun setSelectedArticle(position: Int) {
        news.value?.get(position).let { selectedArticle.value = it }
    }
}