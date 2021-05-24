package com.nhom2.cinemamanagement.security;


import com.nhom2.cinemamanagement.handler.OnAuthenFailure;
import com.nhom2.cinemamanagement.handler.OnAuthenSuccess;
import com.nhom2.cinemamanagement.service.CustomerDetailsServiceImp;
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
                .antMatchers("/", "/login", "/login_error", "/css/**", "/fonts/**", "/images/**",
                        "/js/**", "/rs-plugin/**", "/twitteroauth/**", "/video/**")
                .permitAll()
                .anyRequest().authenticated()
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
