package com.example.managerment_player_footbal.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().antMatchers("/", "/index", "/login").permitAll();
        http.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN");
        http.authorizeHttpRequests().antMatchers("/user/**").hasAnyRole("ADMIN", "USER");
        http.authorizeHttpRequests().antMatchers("/coach/**").hasAnyRole("ADMIN", "COACH");
        http.authorizeHttpRequests().antMatchers("/doctor/**").hasAnyRole("ADMIN", "DOCTOR");
        http.authorizeHttpRequests().and().exceptionHandling().accessDeniedPage("/deny");
        http.authorizeHttpRequests().and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("accountname")
                .passwordParameter("password")
                .defaultSuccessUrl("/mapping")
                .failureUrl("/login?error=true")
                .and()
                .rememberMe()
                .key("yourKey")
                .rememberMeCookieName("yourCookieName")
                .tokenValiditySeconds(86400)
                .and()
                .logout().logoutUrl("/doLogout").logoutSuccessUrl("/login");
    }
}
