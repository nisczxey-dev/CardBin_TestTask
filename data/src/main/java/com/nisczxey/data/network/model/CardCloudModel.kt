package com.nisczxey.data.network.model

import com.google.gson.annotations.SerializedName

data class CardCloudModel(
    @SerializedName("number")
    val number: Number,
    @SerializedName("scheme")
    val scheme: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("prepaid")
    val prepaid: Boolean,
    @SerializedName("country")
    val country: Country,
    @SerializedName("bank")
    val bank: Bank
)
