package com.cactus.cifracherry.presentation.home.listalbuns

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cactus.cifracherry.common.BindableAdapter
import com.cactus.cifracherry.common.CallClickAlbum
import com.cactus.cifracherry.data.model.Album
import com.cactus.cifracherry.databinding.ItemAlbumBinding

class AlbumAdapter(
    private val onClick: CallClickAlbum? = null
) : RecyclerView.Adapter<AlbumViewHolder>(), BindableAdapter<Album> {

    override fun setData(items: List<Album>) {
        listAlbum = items
        notifyDataSetChanged()
    }

    override fun deleteItem(position: Int?) {
    }


    override fun changedPositions(positions: Set<Int>) {
        positions.forEach(this::notifyItemChanged)
    }

    var listAlbum = emptyList<Album>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAlbumBinding.inflate(layoutInflater, parent, false)
        val vielModel = ItemAlbumViewModel()
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
        onClick: CallClickAlbum?
    ) {

        binding.viewmodel?.album = album
        binding.viewmodel?.onClickAlbum = onClick
        binding.invalidateAll()

    }
}