package com.kyu0.helloissue.util.api

class ApiResult<T> (
    val success: Boolean,
    val response: T,
    val error: ApiError?
)