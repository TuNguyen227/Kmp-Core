package com.nmt.kmpcore.network.model

sealed class ResultWrapper<out T> {
    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Error(val message: String, val throwable: Throwable? = null, val code: Int) : ResultWrapper<Nothing>()
}