package com.example.lab57

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val songs = mutableListOf<SongModel>()
        val types = arrayOf("song", "album")
        for (i in 1..10000) {
            val t = types[(Math.random() * types.size).toInt()]
            songs.add(SongModel("Bài hát $i", "Ca sỹ $i", t))
        }

        val recycler = findViewById<RecyclerView>(R.id.recyclerSongs)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = SongAdapter(songs)
    }
}