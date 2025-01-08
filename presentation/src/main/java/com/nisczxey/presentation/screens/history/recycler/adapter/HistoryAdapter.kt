package com.nisczxey.presentation.screens.history.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nisczxey.presentation.databinding.ItemCardHistoryBinding
import com.nisczxey.presentation.screens.history.recycler.diffUtil.HistoryItemDiffUtil
import com.nisczxey.presentation.screens.models.CardCustomUiModel

class HistoryAdapter :
    ListAdapter<CardCustomUiModel, HistoryViewHolder>(HistoryItemDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewBinding =
            ItemCardHistoryBinding.inflate(inflater, parent, false)
        return HistoryViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}