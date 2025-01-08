package com.nisczxey.presentation.screens.history.recycler.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.nisczxey.presentation.screens.models.CardCustomUiModel

class HistoryItemDiffUtil : DiffUtil.ItemCallback<CardCustomUiModel>() {
    override fun areItemsTheSame(oldItem: CardCustomUiModel, newItem: CardCustomUiModel): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(
        oldItem: CardCustomUiModel,
        newItem: CardCustomUiModel
    ): Boolean {
        return oldItem == newItem
    }
}