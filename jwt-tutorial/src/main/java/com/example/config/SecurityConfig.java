package com.example.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers(
                        "/h2-console/**"
                        ,"/favicon.ico"
                        ,"/error"
                );
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//해당 요청은 security 제외
		http
			.authorizeRequests()
			.antMatchers("/api/hello").permitAll()
			.anyRequest().authenticated();
	}
}
