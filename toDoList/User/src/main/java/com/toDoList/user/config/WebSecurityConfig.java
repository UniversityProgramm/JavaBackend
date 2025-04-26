package com.toDoList.user.config;

import com.toDoList.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Отключение CSRF защиты
                .csrf(csrf -> csrf.disable())
                // Настройка правил доступа
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/registration").not().fullyAuthenticated()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/", "/resources/**").permitAll()
                        .anyRequest().authenticated()
                )
                // Настройка формы входа
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                // Настройка выхода
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/")
                );
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }
}