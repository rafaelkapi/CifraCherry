package com.cactus.cifracherry.presentation.home.listAlbuns

import android.app.Activity
import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.cactus.cifracherry.common.BindableAdapter
import com.cactus.cifracherry.common.FunClickAlbum
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.databinding.ItemAlbumBinding
import com.cactus.cifracherry.presentation.home.HomeActivity
import com.cactus.cifracherry.presentation.home.HomeViewModel

class AlbumAdapter(
    private val onClick: FunClickAlbum? = null
) : RecyclerView.Adapter<AlbumViewHolder>(), BindableAdapter<Album> {

    override fun setData(items: List<Album>) {
        listAlbum = items
        notifyDataSetChanged()
    }

    override fun changedPositions(positions: Set<Int>) {
        positions.forEach(this::notifyItemChanged)
    }

    var listAlbum = emptyList<Album>()

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
        binding.invalidateAll()

    }
}