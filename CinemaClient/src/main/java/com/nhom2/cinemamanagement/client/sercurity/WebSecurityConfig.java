package com.nhom2.cinemamanagement.client.sercurity;

import com.nhom2.cinemamanagement.client.handler.OnAuthen2Success;
import com.nhom2.cinemamanagement.client.handler.OnAuthenFailure;
import com.nhom2.cinemamanagement.client.handler.OnAuthenSuccess;
import com.nhom2.cinemamanagement.client.service.CustomOAuth2UserService;
import com.nhom2.cinemamanagement.client.service.CustomerDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    OnAuthen2Success onAuthen2Success;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        System.out.println("userDetailsService *********");
        return new CustomerDetailsServiceImp();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/movie-page-left", "/login", "/login_error", "/css/**", "/fonts/**", "/images/**",
                        "/js/**", "/rs-plugin/**", "/twitteroauth/**", "/video/**")
                .permitAll()
                .anyRequest().authenticated()
                .and().oauth2Login().loginPage("/login").permitAll()
                .userInfoEndpoint().userService(customOAuth2UserService)
                .and().successHandler(onAuthen2Success)
                .and().formLogin().loginPage("/login").permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginProcessingUrl("/dologin")
                .failureHandler(new OnAuthenFailure())
                .successHandler(new OnAuthenSuccess())
                .and().exceptionHandling().accessDeniedPage(("/403"))
        ;
    }
}
