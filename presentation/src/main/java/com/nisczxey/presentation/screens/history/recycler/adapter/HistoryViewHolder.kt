package com.nisczxey.presentation.screens.history.recycler.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nisczxey.presentation.databinding.ItemCardHistoryBinding
import com.nisczxey.presentation.screens.models.CardCustomUiModel

class HistoryViewHolder(private val itemBinding: ItemCardHistoryBinding) :
    ViewHolder(itemBinding.root) {
    fun onBind(cardItem: CardCustomUiModel) = with(itemBinding) {
        tvBankName.text = cardItem.bank.name
        tvDate.text = cardItem.savedDate
        tvBrand.text = cardItem.brand
        tvCountry.text = cardItem.country
        tvType.text = cardItem.type
    }
}