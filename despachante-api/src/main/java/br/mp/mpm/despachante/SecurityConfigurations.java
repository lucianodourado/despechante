package br.mp.mpm.despachante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

// import br.mp.mpm.acasisclient.authentication.mpm.filter.RedeMpmTokenFilter;
// import br.mp.mpm.acasisclient.security.token.TokenService;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	// @Autowired
	// private TokenService tokenService;
	
	// @Bean
	// protected TokenService tokenBean() {
	// 	return new TokenService();
	// }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().sameOrigin();
		
		http.authorizeRequests()
				.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
				.antMatchers(HttpMethod.GET, "/internal/v1/**").permitAll()
				.antMatchers(HttpMethod.PUT, "/internal/v1/**").permitAll()				
				.anyRequest().fullyAuthenticated()
				.and()
				//.addFilterBefore(new RedeMpmTokenFilter(tokenService),
				//		AnonymousAuthenticationFilter.class)				
				.csrf().disable().
					sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/obterToken", //Tem que ficar aqui porque quando vc usa o permitAll o usuário tem que ser não anônimo				
				"/swagger-ui.html", 
				"/v2/api-docs", 
				"/webjars/**", 
				"/configuration/**",
				"/swagger-resources/**");
	}

}
