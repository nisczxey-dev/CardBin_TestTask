package com.nisczxey.domain.model

sealed class Result {
    data class Success(val data: CardModel) : Result()
    data class Error(val error: String) : Result()
}