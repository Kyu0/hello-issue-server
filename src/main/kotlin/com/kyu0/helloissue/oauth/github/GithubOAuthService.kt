package com.kyu0.helloissue.oauth.github

import com.kyu0.helloissue.oauth.GithubOAuthRequest
import com.kyu0.helloissue.oauth.GithubOAuthResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface GithubOAuthService {

    @Headers(
        "Accept: application/json"
    )
    @POST("login/oauth/access_token")
    fun getToken(@Body body: GithubOAuthRequest): Call<GithubOAuthResponse>
}