package com.cactus.cifracherry.presentation.home.listcard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cactus.cifracherry.common.FunClickMusician
import com.cactus.cifracherry.databinding.ItemCardBinding
import com.cactus.cifracherry.data.model.Musician

class CardsAdapter (private val listCards: List<Musician>,
                    private val onClickMark: FunClickMusician? = null,
                    private val onClickDelete: FunClickMusician? = null
) : RecyclerView.Adapter<CardsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(layoutInflater, parent, false)
        val vielModel = CardViewModel()
        binding.viewmodel = vielModel
        return CardsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val user = listCards[position]
        holder.bind(user, onClickMark, onClickDelete)
    }

    override fun getItemCount(): Int = listCards.size
}

class CardsViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        user: Musician,
        onClickMark: FunClickMusician?,
        onClickDelete: FunClickMusician? ) {

        binding.viewmodel?.user = user
        binding.viewmodel?.onClickButtonMark = onClickMark
        binding.viewmodel?.onClickButtonDelete = onClickDelete
        binding.executePendingBindings()
    }


}

