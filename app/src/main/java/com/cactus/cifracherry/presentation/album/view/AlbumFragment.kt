package com.cactus.cifracherry.presentation.album.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cactus.cifracherry.R
import com.cactus.cifracherry.databinding.FragmentAlbumBinding
import com.cactus.cifracherry.presentation.album.AlbumViewModel
import com.cactus.cifracherry.presentation.album.listmusic.MusicAdapter
import kotlinx.android.synthetic.main.fragment_album.*
import kotlinx.android.synthetic.main.menu_album.*


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

        setBackArrow()
        setupRecyclerViewMusics()
        viewModel.apply {
            callShowMenuEdit = {showMenuEdit()}
        }
    }

    fun setupRecyclerViewMusics(){
        rv_musics.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MusicAdapter(
                { x -> viewModel.onClickMusic(x) },
                { x, y -> viewModel.menuOptionsMusic(x, y) }
            )
        }
    }

    fun setBackArrow(){
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar.let {
            it?.setDisplayHomeAsUpEnabled(true)
            it?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
            it?.setTitle(null)
        }
    }


    fun showMenuEdit() {
        motion_album_menu.apply {
            visibility = View.VISIBLE
            transitionToEnd()
            setTransitionDuration(300)
            setTransitionListener(object : MotionLayout.TransitionListener {

                override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                    if (currentId == R.id.state_start_edit)
                        motionLayout?.visibility = View.GONE
                }

                override fun onTransitionChange(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                    progress: Float,
                ) {
                }

                override fun onTransitionStarted(
                    motionLayout: MotionLayout?,
                    startId: Int,
                    endId: Int,
                ) {
                }

                override fun onTransitionTrigger(
                    motionLayout: MotionLayout?,
                    triggerId: Int,
                    positive: Boolean,
                    progress: Float,
                ) {
                }
            })
        }

        v_mask.setOnClickListener {
            motion_album_menu.apply {
                transitionToStart()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}