package com.example.aplikasiandroidsederhana.adapter

import com.example.aplikasiandroidsederhana.model.Article

interface OnItemArticleClick {
    fun clickListener(articles: Article)
}