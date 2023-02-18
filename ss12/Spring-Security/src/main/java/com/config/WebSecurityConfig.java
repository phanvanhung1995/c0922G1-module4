package com.config;

import com.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();


        http.authorizeRequests().antMatchers("/login","/home").permitAll();

        http.authorizeRequests().antMatchers("/list").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')");


        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");


        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error=true")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/home");


        http.authorizeRequests().and()
                .rememberMe().tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(60 * 60 * 24);
    }


    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}