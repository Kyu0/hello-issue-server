package com.kyu0.helloissue.extra

import com.kyu0.helloissue.extra.github.GithubService
import com.kyu0.helloissue.util.api.ApiResult
import com.kyu0.helloissue.util.api.ApiUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class InfoController(
    @Autowired val githubService: GithubService
) {

    @GetMapping("/api/v1/extra/github")
    fun getGithubInfo(): ApiResult<*> {
        return ApiUtils.success(githubService.githubInfo)
    }
}