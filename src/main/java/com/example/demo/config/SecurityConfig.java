package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF (Cross-Site Request Forgery) as this is an API
            .csrf(AbstractHttpConfigurer::disable)
            
            // 2. Configure endpoint permissions
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/v3/api-docs/**",       // Allow OpenAPI docs
                    "/swagger-ui/**",        // Allow Swagger UI
                    "/swagger-ui.html",
                    "/auth/**",              // Allow login/register endpoints
                    "/error",                // Allow default error page
                    "/api/**"                // TEMPORARY: Allow all API access for easy testing
                ).permitAll()
                // .anyRequest().authenticated() // Uncomment this later to secure other endpoints
                .anyRequest().permitAll()        // Currently permits everything to stop the login page
            )
            
            // 3. DISABLE the default login form
            .formLogin(AbstractHttpConfigurer::disable)
            
            // 4. Disable HTTP Basic Auth popup
            .httpBasic(AbstractHttpConfigurer::disable);

        return http.build();
    }
}