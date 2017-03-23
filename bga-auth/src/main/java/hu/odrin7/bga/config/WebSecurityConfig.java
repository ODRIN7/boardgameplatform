package hu.odrin7.bga.config;

import hu.odrin7.bga.service.security.MongoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("SpringFacetCodeInspection")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MongoUserDetailsService mongoUserDetailsService;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public WebSecurityConfig(MongoUserDetailsService mongoUserDetailsService) {
        this.mongoUserDetailsService = mongoUserDetailsService;
    }

    @Bean()
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and()
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/actuator").permitAll()
            .antMatchers("/autoconfig").permitAll()
            .antMatchers("/beans").permitAll()
            .antMatchers("/configprops").permitAll()
            .antMatchers("/dump").permitAll()
            .antMatchers("/env").permitAll()
            .antMatchers("/flyway").permitAll()
            .antMatchers("/health").permitAll()
            .antMatchers("/info").permitAll()
            .antMatchers("/liquibase").permitAll()
            .antMatchers("/metrics").permitAll()
            .antMatchers("/mappings").permitAll()
            .antMatchers("/shutdown").denyAll()
            .antMatchers("/trace").permitAll()
            .antMatchers("/docs").permitAll()
            .antMatchers("/heapdump").permitAll()
            .antMatchers("/jolokia").permitAll()
            .antMatchers("/logfile").permitAll()
            .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mongoUserDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }
}




