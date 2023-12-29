package com.rushi.springboot.security;

import static com.rushi.springboot.security.ApplicationUserRole.ADMIN;
import static com.rushi.springboot.security.ApplicationUserRole.STUDENT;
import static org.springframework.security.config.Customizer.withDefaults;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ApplicationSecurityConfig {

	private final PasswordEncoder passwordEncoder ;


    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	@Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

    http
            .authorizeHttpRequests(requests -> requests
            		
            		.requestMatchers("/","index.html","/css/*","/js/*")// allowed without autheneti-cations
            		.permitAll()
            		.requestMatchers("/api/**").hasRole(STUDENT.name()) // has only access to Student
            		.anyRequest()
                    .authenticated())
            .httpBasic(withDefaults());
	
	return http.build();
}
    
    @Bean
    protected UserDetailsService userDetailService()
    {
    	UserDetails renugundreUser = User.builder()
    	.username("renugundre")
    	.password(passwordEncoder.encode("password"))
    	.roles(STUDENT.name())  // role_student
    	.build();
    	
    	UserDetails rushimithagare = User.builder()
    			.username("rushimithagare")
    			.password(passwordEncoder.encode("rushi@1"))
    			.roles(ADMIN.name())
    			.build();
	
    	return new InMemoryUserDetailsManager(
    			renugundreUser,
    			rushimithagare
    			);
    	
    }
	
	
	

}
