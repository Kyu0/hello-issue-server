package com.kyu0.helloissue.oauth

import com.google.gson.annotations.SerializedName
import com.kyu0.helloissue.extra.github.GithubInfo
import com.kyu0.helloissue.extra.github.GithubInfoService
import com.kyu0.helloissue.oauth.github.GithubOAuthService
import com.kyu0.helloissue.util.api.ApiResult
import com.kyu0.helloissue.util.api.ApiUtils
import com.skydoves.sandwich.*
import com.skydoves.sandwich.retrofit.request
import com.skydoves.sandwich.retrofit.statusCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OAuthController(
    @Autowired val githubInfoService: GithubInfoService,
    @Autowired val githubOAuthService: GithubOAuthService
) {
    @PostMapping("/api/v1/oauth/github")
    fun authGithub(@RequestBody body: GithubOAuthRequest): ApiResult<*> {
        body.update(githubInfoService.githubInfo)

        return ApiUtils.success(githubOAuthService.getToken(body).execute().body())
    }
}

data class GithubOAuthRequest(
    @SerializedName("code")
    val code: String
) {
    @SerializedName("client_secret")
    lateinit var clientSecret: String
    @SerializedName("client_id")
    lateinit var clientId: String

    fun update(githubInfo: GithubInfo) {
        this.apply {
            clientId=githubInfo.clientId
            clientSecret=githubInfo.clientSecret
        }
    }
}

data class GithubOAuthResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("scope")
    val scope: String,
    @SerializedName("token_type")
    val tokenType: String
)
