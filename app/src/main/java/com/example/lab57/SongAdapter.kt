package com.example.lab57

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongAdapter(private val items: List<SongModel>) : RecyclerView.Adapter<SongAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.imgAvatar)
        val txtName: TextView = itemView.findViewById(R.id.txtSongName)
        val txtArtist: TextView = itemView.findViewById(R.id.txtArtist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_song, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.txtName.text = item.songName
        holder.txtArtist.text = item.songArtist

        if (item.songType == "song") {
            holder.img.setImageResource(R.drawable.song_avatar1)
        } else {
            holder.img.setImageResource(R.drawable.song_avatar2)
        }
    }

    override fun getItemCount(): Int = items.size

}
