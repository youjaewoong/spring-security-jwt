package com.example.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//step3 
//TokenProvider, JwtFilter를 SecurityConfig에 적용할때 사용할 JwtSecurityConfig 클래스
public class JwtSecurityConfig  extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
	
	private TokenProvider tokenProvider;
	
    public JwtSecurityConfig(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity http) {
    	//jwtFilter를 security로직에 필터를 등록한다.
        JwtFilter customFilter = new JwtFilter(tokenProvider);
        //SecurityConfig에 등록한다.
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
