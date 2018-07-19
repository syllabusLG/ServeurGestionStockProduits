package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*//authentication in memory
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("user").password("password1").roles("USER").and()
		.withUser("admin").password("password2").roles("USER", "ADMIN");*/
		
		//authentication in database
		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
				.and()
					.authorizeRequests().antMatchers("/api/**").hasRole("USER")
										.antMatchers("/**").hasRole("ADMIN")
										.and()
											.csrf().disable().headers().frameOptions().disable();
	}

}
