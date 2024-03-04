package com.kyu0.helloissue.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig: WebMvcConfigurer {

    override fun addCorsMappings(registry: CorsRegistry) {
        registry
            .addMapping("/**")
            .allowedOrigins("chrome-extension://lmpoamalgihhgfpejaemdecjkanmgmmc")
            .allowedMethods("*")
            .allowCredentials(true)
            .maxAge(3600)
    }
}