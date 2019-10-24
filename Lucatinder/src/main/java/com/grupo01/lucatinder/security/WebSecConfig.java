package com.grupo01.lucatinder.security;

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

import com.grupo01.lucatinder.services.SecurityServiceImpl;



@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
		 private SecurityServiceImpl ss; 
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Bean
	public BCryptPasswordEncoder codificadorClave() {
		return new BCryptPasswordEncoder();
	}

	
    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
    
    	      
    	    
    	
		auth.userDetailsService(ss).passwordEncoder(bCrypt);	
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/mvc/profile/index").permitAll()
                .and().formLogin()
                .defaultSuccessUrl("/mvc/profile/home", true)
                .and().logout();
    	
	
    }
    
 
	
}