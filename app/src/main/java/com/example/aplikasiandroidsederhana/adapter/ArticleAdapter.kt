package com.example.aplikasiandroidsederhana.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasiandroidsederhana.R
import com.example.aplikasiandroidsederhana.model.Article

class ArticleAdapter(private val articles: List<Article>, private val clickListener: (Article) -> Unit) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article) {
            val articleImage = this.itemView.findViewById<ImageView>(R.id.articleImage)
            val articleTitle = this.itemView.findViewById<TextView>(R.id.articleTitle)
            val articleOverview = this.itemView.findViewById<TextView>(R.id.articleOverview)

            articleImage.setImageResource(article.imageResourceId)
            articleTitle.text = article.title
            articleOverview.text = article.overview
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_article,parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])

        holder.itemView.setOnClickListener{
            clickListener(articles[position])
        }
    }

    override fun getItemCount() : Int {
        return  articles.size
    }
}
