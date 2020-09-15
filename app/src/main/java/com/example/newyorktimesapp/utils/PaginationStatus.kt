package com.example.newyorktimesapp.utils

sealed class PaginationStatus {
    object Loading : PaginationStatus()
    object Empty : PaginationStatus()
    object NotEmpty : PaginationStatus()
    data class Error(val errorMsg: String) : PaginationStatus()
}