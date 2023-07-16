package com.olakunle.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails userStudent = User.builder()
                .username("William")
                .password(passwordEncoder().encode("bright"))
                .roles(ApplicationUserRole.STUDENT.name())
                .build();
        UserDetails userAdmin = User.builder()
                .username("Olakunle")
                .password(passwordEncoder().encode("seven"))
                .roles(ApplicationUserRole.ADMIN.name())
                .build();
        UserDetails userTrainee = User.builder()
                .username("Lawrence")
                .password(passwordEncoder().encode("zenith"))
                .roles(ApplicationUserRole.TRAINEE.name())
//                .authorities(ApplicationUserRole.TRAINEE.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                userStudent,
                userTrainee,
                userAdmin
        );
    }
}
