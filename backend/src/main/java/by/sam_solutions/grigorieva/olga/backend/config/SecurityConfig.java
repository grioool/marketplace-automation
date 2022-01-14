package by.sam_solutions.grigorieva.olga.backend.config;

import by.sam_solutions.grigorieva.olga.backend.config.jwt.JwtAuthenticationFilter;
import by.sam_solutions.grigorieva.olga.backend.config.jwt.JwtAuthorizationFilter;
import by.sam_solutions.grigorieva.olga.backend.config.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthorizationFilter jwtAuthorizationFilter;
    private final JwtProvider jwtProvider;
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        JwtAuthenticationFilter customAuthenticationFilter = new JwtAuthenticationFilter(authenticationManagerBean(), jwtProvider);
//        customAuthenticationFilter.setFilterProcessesUrl("/login");
//        http.csrf().disable();
//        http.sessionManagement().sessionCreationPolicy(STATELESS);
//        http.authorizeRequests().antMatchers("/login/**", "/token/refresh/**").permitAll();
//        http.authorizeRequests().antMatchers(GET, "/user/**").hasAnyAuthority("USER");
//        http.authorizeRequests().antMatchers(POST, "/user/create/**").hasAnyAuthority("ADMIN");
//        http.authorizeRequests().anyRequest().authenticated();
//        http.addFilter(customAuthenticationFilter);
//        http.addFilterBefore(jwtAuthorizationFilter, JwtAuthenticationFilter.class);


        JwtAuthenticationFilter customAuthenticationFilter = new JwtAuthenticationFilter(authenticationManagerBean(), jwtProvider);
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http
                .csrf().disable()
                .cors().disable()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/token/refresh", "/registration").permitAll()
                .antMatchers(GET, "/user/**").hasAnyAuthority("USER")
                .antMatchers(POST, "/user/create/**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilter(customAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, JwtAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
