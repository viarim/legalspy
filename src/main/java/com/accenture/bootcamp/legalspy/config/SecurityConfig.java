package com.accenture.bootcamp.legalspy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.accenture.bootcamp.legalspy.model.CurrentUser;
import com.accenture.bootcamp.legalspy.model.Employee;
import com.accenture.bootcamp.legalspy.model.EmployeeManager;
import com.accenture.bootcamp.legalspy.model.LegalUser;
import com.accenture.bootcamp.legalspy.model.LegalUserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/bootstrap/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				// .antMatchers("/", "/index").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
//	    	EmployeeManager em = new EmployeeManager();
//	    	Employee e = em.login(email);
//	    	e.getId();
//	    	e.getName();
//	    	e.getSurname();
//	    	e.getAccessLevel();
//	    	e.getPassword();

	        UserDetails user =
	        		User.withDefaultPasswordEncoder()
	                .username("user")
	                .password("pass")
	                .roles("USER")
	                .build();

//		LegalUserDetails user1 = (LegalUserDetails) LegalUser.withDefaultPasswordEncoder()
//				.username("user")
//				.password("pass")
//				.roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}
}
