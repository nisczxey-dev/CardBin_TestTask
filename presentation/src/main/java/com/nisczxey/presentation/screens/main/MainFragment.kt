package com.nisczxey.presentation.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nisczxey.presentation.databinding.FragmentMainBinding
import com.nisczxey.presentation.screens.models.CardCustomUiModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()

        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            if (uiState.isNeedToShowError) {
                showError(uiState.error.toString())
            }
            if (uiState.data != null) showCard(uiState.data)
        }
    }

    private fun initListeners() = with(binding) {
        btnGetCardInfo.setOnClickListener {
            val bin = edInputBin.text.toString()
            viewModel.getCardInfo(bin)
        }
    }

    private fun showCard(uiModel: CardCustomUiModel) = with(binding) {
        bankCardView.setDataByUiModel(uiModel)
        if (bankCardView.visibility != View.VISIBLE) bankCardView.visibility = View.VISIBLE
    }

    private fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        viewModel.errorShown(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}