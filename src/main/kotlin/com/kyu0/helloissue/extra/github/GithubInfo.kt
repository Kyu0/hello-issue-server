package com.kyu0.helloissue.extra.github

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application-secret.properties")
class GithubInfo(

    @Value("\${github.client.id}")
    val clientId: String,

    @JsonIgnore
    @Value("\${github.client.secret}")
    val clientSecret: String
)