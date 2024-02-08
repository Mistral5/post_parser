package com.example.post_parser.data

sealed class DataState {
  data class Success<T>(val data: T) : DataState()

  data object Loading : DataState()

  data class Error(val exception: Exception) : DataState()
}
