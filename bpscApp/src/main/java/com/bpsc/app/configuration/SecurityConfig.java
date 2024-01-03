package  com.bpsc.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.bpsc.app.configuration.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	 private JwtFilter jwtRequestFilter;
	@Autowired
	private CustomUserDetailsService userDetailsService;


	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	    
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService) // Set your custom userDetailsService here
	            .passwordEncoder(passwordEncoder()); // Set your password encoder here
	    }

	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	 http
	         .cors().and()
	         .csrf().disable()
	            .authorizeRequests()
	                .antMatchers("/api/v1/auth/**").permitAll() // Allow authentication endpoints
	                .antMatchers("/files/view/**").permitAll()
	                .antMatchers("/otp/**").permitAll()
	                .antMatchers("/prepareiiqa/**").permitAll()
	                .anyRequest().authenticated() // Require authentication for other endpoints
	            .and()
	            .exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint())
	            .and()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	        // Add JWT token filter before UsernamePasswordAuthenticationFilter
	        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	    }
}
