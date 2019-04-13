package com.tampro.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tampro.Service.UserSecurityService;

@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfig2 extends WebSecurityConfigurerAdapter{

	@Autowired
	UserSecurityService userSecurityService;

     private BCryptPasswordEncoder passwordEncoder() {
    	 return SecurityUtility.passwordEncoder();
     }
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		 .and().formLogin()
		.loginPage("/login-admin").loginProcessingUrl("/admin/dang-nhap")
		.defaultSuccessUrl("/admin/home").failureUrl("/login-admin?err=loginfailed")
		.and().exceptionHandling().accessDeniedPage("/login-admin");
		/*
		 * http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		 .and().formLogin()
		.loginPage("/login-admin").loginProcessingUrl("/admin/dang-nhap")
		.defaultSuccessUrl("/admin/home").failureUrl("/login-admin?err=loginfailed")
		.and().exceptionHandling().accessDeniedPage("/login-admin");
		
		
		http.csrf().disable().antMatcher("/user/**").authorizeRequests().antMatchers("/user/**").hasRole("USER").and().formLogin()
		.loginPage("/login").loginProcessingUrl("/user/dang-nhap")
		.defaultSuccessUrl("/home").failureUrl("/login?err=loginfailed")
		.and().exceptionHandling().accessDeniedPage("/login");
		 * */
		
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/css/**","/js/**","/img/**");
	}


}
