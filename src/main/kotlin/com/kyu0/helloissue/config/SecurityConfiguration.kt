package com.kyu0.helloissue.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests{ requests ->
                requests
                    .anyRequest().permitAll()
            }
            .httpBasic{ httpBasic ->
                httpBasic.disable()
            }
            .csrf{ csrf ->
                csrf.disable()
            }
            .cors { cors ->
                cors.disable()
            }

        return http.build()
    }
}