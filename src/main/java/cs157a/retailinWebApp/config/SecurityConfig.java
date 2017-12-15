package cs157a.retailinWebApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource myDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//			.withUser("user").password("user").roles("ADMIN");
//		auth.inMemoryAuthentication()
//			.withUser("user2").password("user2").roles("EMPLOYEE");
		auth.jdbcAuthentication().dataSource(myDataSource);
	}

	// Provide the routing depending on the authentication
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login", "/resources/**").permitAll()
				.antMatchers("/admin", "/user/*").hasRole("ADMIN")
					.anyRequest().authenticated()
					.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateUser")
				.and()
			.httpBasic();
	}
}