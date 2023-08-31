package com.example.GameSchedule.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/user/**").permitAll().and().formLogin().loginPage("/signin").loginProcessingUrl("/login")
		.defaultSuccessUrl("/admin/")
		.and().logout().logoutSuccessUrl("/login?logout")
		.and().csrf().disable();
	}
	
	
	
}
