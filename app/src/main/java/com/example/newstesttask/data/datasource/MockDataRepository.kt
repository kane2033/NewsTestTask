package com.example.newstesttask.data.datasource

import com.example.newstesttask.domain.entity.Article

/**
* Тестовое возвращение данных, которое можно заменить на другой источник данных
 * (но для этого нужно дополнительно реализовать асинхронность)
* */
object MockDataRepository {

    fun getNews(): List<Article> = listOf(
        Article(null, "Dec. 26, 2017",
        "We released new AR game for iOS - AR Darts One. Play it with your favorite enemy photo on dartboard in any of 3 game modes available and try to beat records."),
        Article("AR Basketball major update", "Oct. 31, 2017",
            "AR Basketball One with major update have been released. A new game ball and ballboard skins are available now."),
        Article("Meet new game by Verysoft AR Basketball", "Sept. 20, 2017",
            "Meet new game by Verysoft AR Basketball One with impressive technology of Augmented Reality for iPhone and iPad!")
    )
}