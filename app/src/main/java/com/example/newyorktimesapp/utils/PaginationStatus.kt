package com.example.newyorktimesapp.utils

sealed class PaginationStatus {
    object Loading : PaginationStatus()
    object Empty: PaginationStatus()
    object NotEmpty : PaginationStatus()
    data class PaginationError(val errorMsg: String)
}