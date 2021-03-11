package com.example.newstesttask.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.example.newstesttask.R
import com.example.newstesttask.presentation.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*

/**
* Фрагмент отображает полную статью.
* */
class ArticleFragment: Fragment(R.layout.fragment_article) {

    // т.к viewmodel такая же, как и у прошлого фрагмента,
    // можно достать выбранный в предыдущем фрагменте элемент
    private val viewModel: NewsViewModel by navGraphViewModels(R.id.newsMasterDetailGraph) {
        defaultViewModelProviderFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Восстанавливаем положение скролла
        scrollView.scrollTo(scrollView.scrollX, viewModel.scrollPosition)

        // Отображаем новость
        viewModel.selectedArticle.value?.let {
            titleView.text = it.title
            dateView.text = it.date
            fullTextView.text = it.fullText
        }
    }
}