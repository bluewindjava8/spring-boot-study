package com.bluewind.actuator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	//Here, password("{noop}admin") means we don't use password encoder.
        auth.inMemoryAuthentication().withUser("admin").password("{noop}blue").roles("ADMIN123");
        
 
    }
    
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	//permit all request( no need to authenticate)
//        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();
//    }
}