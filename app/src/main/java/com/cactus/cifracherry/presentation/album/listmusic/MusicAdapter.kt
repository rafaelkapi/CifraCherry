package com.cactus.cifracherry.presentation.album.listmusic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cactus.cifracherry.common.BindableAdapter
import com.cactus.cifracherry.common.LambdaClickMusic
import com.cactus.cifracherry.data.model.Music
import com.cactus.cifracherry.databinding.ItemMusicBinding

class MusicAdapter(
    private val onClick: LambdaClickMusic? = null
) : RecyclerView.Adapter<MusicViewHolder>(), BindableAdapter<Music> {

    override fun setData(items: List<Music>) {
        listMusic = items
        notifyDataSetChanged()
    }

    override fun changedPositions(positions: Set<Int>) {
        positions.forEach(this::notifyItemChanged)
    }

    var listMusic = emptyList<Music>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMusicBinding.inflate(layoutInflater, parent, false)
        val vielModel = ItemMusicViewModel()
        binding.viewmodel = vielModel
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        var music = listMusic[position]
        holder.bind(music, onClick)
    }

    override fun getItemCount(): Int = listMusic.size
}

class MusicViewHolder(private val binding: ItemMusicBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        music: Music,
        onClick: LambdaClickMusic?
    ) {
        binding.viewmodel?.setItem(music)
        binding.viewmodel?.onClickMusic= onClick
        binding.invalidateAll()
    }
}