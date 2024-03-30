package Durgesh.StreamApi.spring.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().requestMatchers("/public/**").hasRole("USER").requestMatchers("/signin").permitAll()
				.requestMatchers("/users/**").hasRole("ADMIN").anyRequest().authenticated().and().formLogin()
				.loginPage("/signin").loginProcessingUrl("/dologin").defaultSuccessUrl("/public/home");
				//invalidate session
				//.and().logout(log->log.addLogoutHandler(new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(COOKIES))));
		return http.build();
	}

//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		UserDetails user = users.username("archana").password("rohan").roles("USER").build();
//		UserDetails admin = users.username("rohan").password("archana").roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user,admin);
//	}
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
