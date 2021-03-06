package com.dealerStat.store;

import com.dealerStat.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationManagerBuilder auth;

    @Autowired
    private UserRepository repository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                    .antMatchers("/", "/login", "/registration", "/css/**", "/fonts/**", "/img/**", "/scripts/**")
                    .permitAll()
                    .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/seller/**").access(" hasRole('ADMIN')or hasRole('TRADER')")
                .antMatchers("/all/**").access( "hasRole('ADMIN') or hasRole('TRADER')")
                .antMatchers("/all/home").access("hasRole('BLOCKED')")
                .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select email, hash_password, true from userAccount where email=?")
                .authoritiesByUsernameQuery("select email, role from userAccount where email=?");

    }
}