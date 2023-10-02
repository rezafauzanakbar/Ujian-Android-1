package com.example.aplikasiandroidsederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.aplikasiandroidsederhana.model.Article
import de.hdodenhof.circleimageview.CircleImageView

class DetailActivity : AppCompatActivity() {
    lateinit var article: Article
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        article = intent.getParcelableExtra("article")!!

        Glide.with(this).load(article.imageResourceId).into(findViewById(R.id.articleDetailImage))
        findViewById<TextView>(R.id.articleDetailTitle).text = article.title
        findViewById<TextView>(R.id.articleDetailOverview).text = article.overview
        findViewById<TextView>(R.id.articleDetailDescription).text = article.description

        val shareButton = findViewById<Button>(R.id.btnShare)
        shareButton.setOnClickListener {
            this.shareArticle(article)
        }

    }


    private fun shareArticle(article: Article) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, article.toString())
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share using"))
    }
}