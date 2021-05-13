package com.cactus.cifracherry.presentation.album.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.cactus.cifracherry.R
import com.cactus.cifracherry.databinding.FragmentCifraBinding
import com.cactus.cifracherry.presentation.album.AlbumViewModel


class CifraFragment : Fragment() {

    private val viewModel: AlbumViewModel by activityViewModels()
    private var _binding: FragmentCifraBinding? = null
    private val binding get() = _binding!!


    companion object {

        @JvmStatic
        fun newInstance() = CifraFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cifra, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}