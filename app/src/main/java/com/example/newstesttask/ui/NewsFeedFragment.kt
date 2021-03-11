package com.example.newstesttask.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.newstesttask.R
import com.example.newstesttask.presentation.NewsDataAdapter
import com.example.newstesttask.presentation.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news_feed.*

/**
* Фрагмент, ответственный за вывод списка новостей
 * и перехода на фрагмент с новостью.
* */
class NewsFeedFragment: Fragment(R.layout.fragment_news_feed) {

    // by navGraphViewModels возвращает один и тот же экземпляр класса, если находимся на указанном
    // графе (master-detail)
    private val viewModel: NewsViewModel by navGraphViewModels(R.id.newsMasterDetailGraph) {
        defaultViewModelProviderFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получаем новости при запуске фрагмента
        viewModel.getNews()

        // Инициализация RecyclerView с адаптером
        val newsAdapter = NewsDataAdapter(clickListener = { position ->
            // Выбранную статью сохраняем в общей viewmodel для master-detail
            viewModel.setSelectedArticle(position)
            findNavController().navigate(R.id.action_newsFeedFragment_to_articleFragment)
        })
        newsRecyclerView.adapter = newsAdapter

        // Обновление списка при получении данных
        viewModel.news.observe(viewLifecycleOwner, {
            newsAdapter.updateList(it)
        })
    }
}