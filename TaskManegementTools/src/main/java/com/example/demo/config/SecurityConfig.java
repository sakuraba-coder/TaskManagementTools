package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * セキュリティの対象外を設定
	 */

	@Override
	public void configure(WebSecurity web) throws Exception {
		//セキュリティを適用しない
		web
			.ignoring()
				.antMatchers("/webjars/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/h2-console/**");
	}


	/**
	 * セキュリティの各種せてい
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/").permitAll() //直リンクOK
//				.antMatchers("/login").permitAll() //直リンクOK
//				.anyRequest().authenticated();//それ以外は直リンNG

//		http
//			.formLogin()
//				.loginProcessingUrl("/")
//				.loginPage("/")
//				.failureUrl("/error")
//				.usernameParameter("name")
//				.passwordParameter("password")
//				.defaultSuccessUrl("/user/list", true);
	}


	/**
	 * 認証の設定
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = passwordEncoder();
		//インメモリ認証
		auth
			.inMemoryAuthentication()
				.withUser("user") //userを追加
					.password(encoder.encode("user"))
					.roles("GENERAL")
				.and()
				.withUser("admin")
					.password(encoder.encode("admin"))
					.roles("ADMIN");

	}



}
