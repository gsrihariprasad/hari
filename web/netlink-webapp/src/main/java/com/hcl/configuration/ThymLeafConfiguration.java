package com.hcl.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableWebSecurity
public class ThymLeafConfiguration extends WebSecurityConfigurerAdapter{
/*
	@Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/london").setViewName("/WEB-INF/templates/london");  
	    registry.addViewController("/paris").setViewName("/paris");
	  }*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.httpBasic().and()
			.authorizeRequests()
				.antMatchers("/index.html","/home", "/home.html", "/login.html", "/").permitAll()
				.anyRequest().authenticated()
				.and()
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		// @formatter:on
	}
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .inMemoryAuthentication()
	                .withUser("user").password("password").roles("USER");
	    }

	
	 @Bean
	 public ServletContextTemplateResolver templateResolver() throws Exception {

		 ServletContextTemplateResolver servletcontexttemplateresolver =
				new ServletContextTemplateResolver();
		 servletcontexttemplateresolver.setPrefix("/WEB-INF/templates/");
		 servletcontexttemplateresolver.setSuffix(".html");
		 servletcontexttemplateresolver.setTemplateMode("HTML5");
			return servletcontexttemplateresolver;

		}
	 
	 @Bean
	 public SpringTemplateEngine templateEngine() throws Exception {

		 SpringTemplateEngine springtemplateengine =
				new SpringTemplateEngine();
		 springtemplateengine.setTemplateResolver(templateResolver());
			return springtemplateengine;

		}
		
	
}
