package pl.dentsys.security.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configurable
@EnableWebSecurity
// Modifying or overriding the default spring boot security.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// overriding some configuration of the WebSecurity
	//ignore some request or request patterns 
	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring()
				.antMatchers("/", "/index.html", "/app/**", "/register", "/authenticate", "/favicon.ico");
	}

	// override HttpSecurity of the web Application.
	// authorization criteria
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.anyRequest().fullyAuthenticated().and()
				.addFilterBefore(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
				.httpBasic().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.csrf().disable();
	}

}
