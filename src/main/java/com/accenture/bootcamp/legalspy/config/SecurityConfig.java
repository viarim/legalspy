package com.accenture.bootcamp.legalspy.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import com.accenture.bootcamp.legalspy.model.Employee;
import com.accenture.bootcamp.legalspy.model.EmployeeManager;

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

	//Retriev and save all users from database
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		EmployeeManager em = new EmployeeManager();
		List<Employee> eList = em.findEmployees();
       	for (Employee employee : eList) {
       		auth.inMemoryAuthentication().withUser(employee.getEmail()).
       		password("{noop}" + employee.getPassword()).roles(employee.getRole());
       	}
	}
}
