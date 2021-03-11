package com.example.newstesttask.domain.entity

/**
* Сущность новости Article
 * (выбрано слово article, потому что
 * news это может быть и ед.ч и мн.ч.)
* */
class Article(title: String?, val date: String, val fullText: String) {

    val title: String = makeTitle(title)

    private fun makeTitle(title: String?): String {
        if (title != null) return truncate(title)

        return truncate(fullText)
    }

    // Обрезание строки, если она больше 20 символов
    private fun truncate(initStr: String): String {
        return if (initStr.length > 20) {
            initStr.take(20) + "..."
        } else {
            initStr
        }
    }
}