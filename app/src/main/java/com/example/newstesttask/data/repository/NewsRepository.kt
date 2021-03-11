package com.example.newstesttask.data.repository

import com.example.newstesttask.data.datasource.MockDataRepository
import com.example.newstesttask.domain.entity.Article

/**
* Репозиторий новостей,
 * возвращающий список новостей из источника данных
* */
class NewsRepository {

    fun getNews(): List<Article> = MockDataRepository.getNews()
}