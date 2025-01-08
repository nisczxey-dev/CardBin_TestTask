package com.nisczxey.presentation.screens.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nisczxey.presentation.databinding.FragmentHistoryBinding
import com.nisczxey.presentation.screens.history.recycler.adapter.HistoryAdapter
import com.nisczxey.presentation.screens.models.CardCustomUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private val viewModel: HistoryViewModel by viewModels()
    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!
    private val adapter: HistoryAdapter by lazy {
        HistoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.uiState.observe(viewLifecycleOwner) {
            if (it.isNeedToShowError) showError(it.error)
            if (it.data != null) showHistory(history = it.data)
        }
        initRecycler()
    }

    private fun initRecycler() = with(binding) {
        rvHistory.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        rvHistory.adapter = adapter
    }

    private fun showHistory(history: List<CardCustomUiModel>) {
        adapter.submitList(history)
    }

    private fun showError(e: String?) {
        Toast.makeText(context, "error: $e", Toast.LENGTH_SHORT).show()
        viewModel.errorShown()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}