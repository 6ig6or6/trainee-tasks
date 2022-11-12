package org.example.shop.security;

import org.example.shop.entity.user.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers(HttpMethod.DELETE, "/api/v1/product/*").hasAnyRole(Role.ADMIN.name(), Role.MANAGER.name())
                .mvcMatchers(HttpMethod.POST, "/api/v1/product").hasAnyRole(Role.ADMIN.name(), Role.MANAGER.name())
                .mvcMatchers(HttpMethod.PUT, "/api/v1/product/*").hasAnyRole(Role.ADMIN.name(), Role.MANAGER.name())
                .mvcMatchers(HttpMethod.GET, "/api/v1/product").permitAll()
                .mvcMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                .mvcMatchers(HttpMethod.DELETE, "/api/v1/user").hasRole(Role.ADMIN.name())
                .mvcMatchers(HttpMethod.PUT, "/api/v1/user").hasRole(Role.ADMIN.name())
                .mvcMatchers(HttpMethod.GET, "/api/v1/user").hasRole(Role.ADMIN.name())
                .mvcMatchers("/api/v1/order").hasRole(Role.ADMIN.name())
                .mvcMatchers("/api/v1/bucket").authenticated();
        http.csrf().disable().httpBasic();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(13);
    }
}
