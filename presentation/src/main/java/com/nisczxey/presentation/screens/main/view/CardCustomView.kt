package com.nisczxey.presentation.screens.main.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.nisczxey.presentation.R
import com.nisczxey.presentation.databinding.CustomCardViewBinding
import com.nisczxey.presentation.screens.models.CardCustomUiModel

class CardCustomView(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: CustomCardViewBinding

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0
    )

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.custom_card_view, this, true)
        binding = CustomCardViewBinding.bind(this)
        initAttrs(attrs, defStyleAttr, defStyleRes)
    }

    private fun initAttrs(
        attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int
    ) {
        if (attrs == null) return

        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.CardCustomView,
            defStyleAttr,
            defStyleRes
        )

        with(binding) {
            val textScheme = typedArray.getString(R.styleable.CardCustomView_schemeText)
            tvScheme.text = textScheme ?: EMPTY_STRING

            val textBrand = typedArray.getString(R.styleable.CardCustomView_brandText)
            tvBrand.text = textBrand ?: EMPTY_STRING

            val textCountry = typedArray.getString(R.styleable.CardCustomView_countryText)
            tvCountry.text = textCountry ?: EMPTY_STRING

            val textBankName = typedArray.getString(R.styleable.CardCustomView_bankNameText)
            tvBank.text = textBankName ?: EMPTY_STRING

            val textBankSite = typedArray.getString(R.styleable.CardCustomView_bankSiteText)
            tvBankUrl.text = textBankSite ?: EMPTY_STRING

            val textBankNumber = typedArray.getString(R.styleable.CardCustomView_bankNumberText)
            tvBankNumber.text = textBankNumber ?: EMPTY_STRING

            val textCardType = typedArray.getString(R.styleable.CardCustomView_cardTypeText)
            tvType.text = textCardType ?: EMPTY_STRING
        }
        typedArray.recycle()
    }

    fun setDataByUiModel(uiModel: CardCustomUiModel) = with(binding) {
        with(this) {
            tvType.text = uiModel.type
            tvBank.text = uiModel.bank.name
            tvBankNumber.text = uiModel.bank.number
            tvBankUrl.text = uiModel.bank.siteUrl
            tvScheme.text = uiModel.scheme
            tvCountry.text = uiModel.country
            tvBrand.text = uiModel.brand
        }
    }

    private companion object {
        const val EMPTY_STRING = ""
    }

}