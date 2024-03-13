package com.example.submissionahmadzidan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name: String? = intent.getStringExtra(EXTRA_NAME)
        val description: String? = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo: Int = intent.getIntExtra(EXTRA_PHOTO, 0)

        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDescription: TextView = findViewById(R.id.tv_item_description)
        val tvPhoto: ImageView = findViewById(R.id.img_item_photo)

        tvName.text = name
        tvDescription.text = description
        tvPhoto.setImageResource(photo)

    }
}