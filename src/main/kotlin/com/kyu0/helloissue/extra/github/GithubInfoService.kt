package com.kyu0.helloissue.extra.github

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GithubInfoService(
    @Autowired val githubInfo: GithubInfo
) {

}