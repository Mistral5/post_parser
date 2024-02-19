package com.example.post_parser.data

sealed interface DataState<out T> {
  data class Success<out T>(val data: T) : DataState<T>

  data object Loading : DataState<Nothing>

  data class Error(val exception: Exception) : DataState<Nothing>
}
