package com.cactus.cifracherry.presentation.album.listmusic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cactus.cifracherry.common.BindableAdapter
import com.cactus.cifracherry.common.CallClickMusic
import com.cactus.cifracherry.common.CallMenuOptionsMusic
import com.cactus.cifracherry.data.model.Music
import com.cactus.cifracherry.databinding.ItemMusicBinding

class MusicAdapter(
    private val onClick: CallClickMusic? = null,
    private val menuOptionsMusic: CallMenuOptionsMusic? = null,
) : RecyclerView.Adapter<MusicViewHolder>(), BindableAdapter<Music> {

    private var listMusic = mutableListOf<Music>()

    override fun setData(items: List<Music>) {
        listMusic = items as MutableList<Music>
        notifyDataSetChanged()
    }

    override fun deleteItem(position: Int?) {
        position?.let {
            listMusic.removeAt(it)
            notifyItemRemoved(it)
            notifyItemRangeChanged(it, listMusic.size)
        }
    }


    override fun changedPositions(positions: Set<Int>) {
        positions.forEach(this::notifyItemChanged)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMusicBinding.inflate(layoutInflater, parent, false)
        val viewModel = ItemMusicViewModel()
        binding.viewmodel = viewModel
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        var music = listMusic[position]
        holder.bind(music, position, onClick, menuOptionsMusic)
    }

    override fun getItemCount(): Int = listMusic.size
}

class MusicViewHolder(private val _binding: ItemMusicBinding) :
    RecyclerView.ViewHolder(_binding.root) {

    fun bind(
        music: Music,
        _position: Int?,
        _onClick: CallClickMusic?,
        _menuOptionsMusic: CallMenuOptionsMusic?,
    ) {
        _binding.viewmodel?.apply {
            setItem(music)
            binding = _binding
            position = _position
            onClickMusic = _onClick
            menuOptionsMusic = _menuOptionsMusic
        }
        _binding.invalidateAll()
    }
}