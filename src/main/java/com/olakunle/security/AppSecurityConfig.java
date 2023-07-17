package com.olakunle.security;

import com.olakunle.auth.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@RequiredArgsConstructor
public class AppSecurityConfig {

    private final ApplicationUserService applicationUserService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails userStudent = User.builder()
                .username("William")
                .password(passwordEncoder().encode("bright"))
//                .roles(ApplicationUserRole.STUDENT.name())
                .authorities(ApplicationUserRole.STUDENT.getGrantedAuthorities())

                .build();
        UserDetails userAdmin = User.builder()
                .username("Olakunle")
                .password(passwordEncoder().encode("seven"))
//                .roles(ApplicationUserRole.ADMIN.name())
                .authorities(ApplicationUserRole.ADMIN.getGrantedAuthorities())
                .build();
        UserDetails userTrainee = User.builder()
                .username("Lawrence")
                .password(passwordEncoder().encode("zenith"))
//                .roles(ApplicationUserRole.TRAINEE.name())
                .authorities(ApplicationUserRole.TRAINEE.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                userStudent,
                userTrainee,
                userAdmin
        );
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(applicationUserService);
        return provider;
    }
}
