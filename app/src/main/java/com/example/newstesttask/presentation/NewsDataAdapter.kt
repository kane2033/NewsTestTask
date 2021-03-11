package com.example.newstesttask.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newstesttask.R
import com.example.newstesttask.domain.entity.Article

class NewsDataAdapter(private val clickListener: (position: Int) -> Unit)
    : RecyclerView.Adapter<NewsDataAdapter.ViewHolder>() {

    private var news: List<Article> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article: Article = news[position]
        holder.bind(article)
    }

    fun updateList(newNews: List<Article>) {
        news = newNews
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = news.size

    inner class ViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_news, parent, false)) {
        private val titleView: TextView = itemView.findViewById(R.id.titleView)
        private val dateView: TextView = itemView.findViewById(R.id.dateView)

        init {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    clickListener(adapterPosition)
                }
            }
        }

        fun bind(article: Article) {
            titleView.text = article.title
            dateView.text = article.date
        }
    }
}