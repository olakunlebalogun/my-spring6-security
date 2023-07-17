package com.olakunle.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

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
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/courses", true)
                        .usernameParameter("username")  // This aligns with the name value in the Username input field in the login form
                        .passwordParameter("password")  // This aligns with the name value in the Password input field in the  login form
                )
                .rememberMe(rm -> rm
                        .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                        .key("somethingVerySecure")
                        .rememberMeParameter("remember-me")  // This aligns with the name value in the Password input field in the  login form
                )
                .logout(log -> log
                        .logoutUrl("/logout")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID", "remember-me")
                        .logoutSuccessUrl("/login")
                )

                .build();
    }
}
