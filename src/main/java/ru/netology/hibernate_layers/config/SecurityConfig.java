package ru.netology.hibernate_layers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;


@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsService() {
        UserDetails userDima = User
                .withUsername("Dima")
                .password(passwordEncoder().encode("112233"))
                .roles("READ", "WRITE", "DELETE")
                .build();
        UserDetails userAnton = User
                .withUsername("Anton")
                .password(passwordEncoder().encode("0000"))
                .authorities("READ", "WRITE")
                .build();
        UserDetails userIvan = User
                .withUsername("Ivan")
                .password(passwordEncoder().encode("0000"))
                .roles("WRITE")
                .build();
        UserDetails userPavel = User
                .withUsername("Pavel")
                .password(passwordEncoder().encode("0000"))
                .roles("WRITE")
                .build();
        UserDetails userSlava = User
                .withUsername("Slava")
                .password(passwordEncoder().encode("0000"))
                .roles("DELETE")
                .build();

        return new InMemoryUserDetailsManager(userDima, userAnton, userIvan, userPavel, userSlava);
    }
}