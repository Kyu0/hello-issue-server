package com.kyu0.helloissue.util.api

object ApiUtils {
    fun <T> success(response: T): ApiResult<T> {
        return ApiResult(true, response, null)
    }

    fun error(message: String, status: Int): ApiResult<*> {
        return ApiResult(false, null, ApiError(message, status))
    }
}