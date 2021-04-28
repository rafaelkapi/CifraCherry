package com.cactus.cifracherry.presentation.home.listAlbuns

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cactus.cifracherry.common.FunClickAlbum
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.databinding.ItemAlbumBinding

class AlbumAdapter(
    private val listAlbum: List<Album>,
    private val onClick: FunClickAlbum? = null
) : RecyclerView.Adapter<AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAlbumBinding.inflate(layoutInflater, parent, false)
        val vielModel = AlbumViewModel()
        binding.viewmodel = vielModel
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        var album = listAlbum[position]
        holder.bind(album, onClick)
    }

    override fun getItemCount(): Int = listAlbum.size
}

class AlbumViewHolder(private val binding: ItemAlbumBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        album: Album,
        onClick: FunClickAlbum?
    ) {

        binding.viewmodel?.album = album
        binding.viewmodel?.onClickAlbum = onClick
        binding.executePendingBindings()

    }
}