package com.olakunle.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "index", "/css/**", "/js/**").permitAll()
                        .requestMatchers("/api/v1/students/**").hasRole(ApplicationUserRole.STUDENT.name())
                        .requestMatchers(HttpMethod.DELETE, "management/api/v1/students/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                        .requestMatchers(HttpMethod.POST, "management/api/v1/students/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                        .requestMatchers(HttpMethod.PUT, "management/api/v1/students/**").hasAuthority(ApplicationUserPermission.COURSE_WRITE.getPermission())
                        .requestMatchers(HttpMethod.GET, "management/api/v1/students/**").hasAnyRole(ApplicationUserRole.ADMIN.name(), ApplicationUserRole.TRAINEE.name())
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
