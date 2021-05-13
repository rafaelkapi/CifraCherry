package com.cactus.cifracherry.presentation.album.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cactus.cifracherry.R
import com.cactus.cifracherry.databinding.FragmentAlbumBinding
import com.cactus.cifracherry.presentation.album.AlbumViewModel
import com.cactus.cifracherry.presentation.album.listmusic.MusicAdapter
import kotlinx.android.synthetic.main.fragment_album.*


class AlbumFragment : Fragment() {

    private val viewModel: AlbumViewModel by activityViewModels()
    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(): AlbumFragment = AlbumFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar.let {
            it?.setDisplayHomeAsUpEnabled(true)
            it?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
            it?.setTitle(null)
        }

        rv_musics.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MusicAdapter({ music -> viewModel.onClickMusic(music) })
        }

        toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}