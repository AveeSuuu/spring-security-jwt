package dev.avee.bettersecurity.configuration.security;

import dev.avee.bettersecurity.common.properties.JwtProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(JwtProperties.class)
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
class SecurityConfig {

    private final JwtProperties jwtProperties;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)

            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )

            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .exceptionHandling(customizer -> customizer
                .accessDeniedHandler(new AccessDeniedHandlerImpl())
                .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
            )

//            .oauth2ResourceServer((oauth2) -> oauth2.jwt(jwt -> jwt.decoder(jwtDecoder())))

            .build();
    }

//    @Bean
//    JwtDecoder jwtDecoder() {
//        NimbusJwtDecoder.withSecretKey();
//    }
//
//    @Bean
//    JwtEncoder jwtEncoder() {
//        return new NimbusJwtEncoder();
//    }
}
