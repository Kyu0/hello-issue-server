package com.kyu0.helloissue.retrofit

import com.kyu0.helloissue.oauth.github.GithubOAuthService
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Configuration
class RetrofitConnection {
    val githubBaseUrl: String = "https://github.com/"

    @Bean
    fun getGithubConnection(): GithubOAuthService {
        return Retrofit.Builder()
            .baseUrl(githubBaseUrl)
//            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create()) // Retrofit2 응답, 에러, 예외 결과를 핸들링하기 위해 Call Adapter 추가
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubOAuthService::class.java)
    }

    /**
     * ApiResponse
     *
     * success: data, statusCode, headers, raw
     * fail: message, errorBody, statusCode, headers, raw
     * exception:
     */
}