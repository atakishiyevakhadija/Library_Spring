package com.library.dea.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
         http
                 .csrf(   csrf -> csrf
                         .ignoringRequestMatchers("/api/**")
                 )
                 .authorizeHttpRequests(auth -> auth
                         //swagger
                         .requestMatchers("/swagger/ui/**", "/v3/api-docs/**", "/api/books/**")
                         .permitAll()
                         //public pages
                         .requestMatchers("/login", "/register", "/css/**", "/js/**")
                         .permitAll()
                         .requestMatchers("/books/new", "/books/edit/**", "/books/delete/**")
                         .hasRole("ADMIN")
                         .requestMatchers("/api/books/**")
                         .hasAnyRole("USER", "ADMIN")
                         .anyRequest()
                         .authenticated()

                 )
                 .formLogin(form -> form
                         .loginPage("/login")
                         .defaultSuccessUrl("/books", true)
                         .permitAll()
                 )
                 .exceptionHandling(ex ->
                         ex.accessDeniedPage("/access-denied"))
                 .logout(logout -> logout
                         .logoutSuccessUrl("/login?logout")
                         .permitAll()
                 );
        return http.build();


        }

        @Bean
        public AuthenticationManager authenticationManager(
                AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
        }
    }

