package ru.netology.hibernate_layers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http.formLogin().and().authorizeHttpRequests().requestMatchers("/persons").permitAll().and().authorizeHttpRequests().requestMatchers("/persons/by-city", "/persons/by-age").hasAnyAuthority("USER", "ADMIN").and().authorizeHttpRequests().requestMatchers("/persons/").hasAuthority("ADMIN").and().authorizeHttpRequests().anyRequest().authenticated().and().build();


    }

    @Bean
    public UserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("Dima").password(passwordEncoder().encode("112233")).authorities("ADMIN").build();
        UserDetails guest = User.withUsername("User").password(passwordEncoder().encode("0000")).authorities("USER").build();

        return new InMemoryUserDetailsManager(admin, guest);
    }

}
