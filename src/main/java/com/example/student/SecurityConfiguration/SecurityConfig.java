package com.example.student.SecurityConfiguration;

import com.example.student.StudentService.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)

public class SecurityConfig {
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return   http.authorizeHttpRequests(authorizeRequests ->
                      authorizeRequests
                      .requestMatchers("/student/**").permitAll()
              .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
              //.formLogin(Customizer.withDefaults())

                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(CustomUserDetailService customUserDetailService) {
    return new CustomUserDetailService();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
    }



@Bean
    public AuthenticationManager authenticationManagerBean(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) throws Exception {
    DaoAuthenticationProvider daoauthenticationProvider = new DaoAuthenticationProvider();
    daoauthenticationProvider.setUserDetailsService(userDetailsService);
    daoauthenticationProvider.setPasswordEncoder(passwordEncoder);
    return new ProviderManager(daoauthenticationProvider);
}

}
