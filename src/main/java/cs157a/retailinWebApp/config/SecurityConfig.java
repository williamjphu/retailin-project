package cs157a.retailinWebApp.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

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
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE")); 
//		SecurityContextHolder.getContext().setAuthentication(
//		        new UsernamePasswordAuthenticationToken(
//		            SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
//		            SecurityContextHolder.getContext().getAuthentication().getCredentials(),
//		            authorities)
//		        );
	}

	// Provide the routing depending on the authentication
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.antMatchers("/user/showFormForAdd").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
					.anyRequest().authenticated()
					.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateUser")
				.and()
			.httpBasic();
	}
}