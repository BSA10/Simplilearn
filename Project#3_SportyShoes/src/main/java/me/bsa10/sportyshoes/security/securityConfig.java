package me.bsa10.sportyshoes.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] permitted = new String[]{
                "/", "/home","/register","sign-up","/about","/png/**",
                "/css/**","/icons/**","/img/**","/image/**","/images/**","/loginStatic/**","/sass/**","/js/**","/layer/**"
        };

        http.csrf().disable().authorizeRequests()
                .antMatchers(permitted).permitAll()
                .antMatchers("/","/contact","/about","/login" , "/sign-up").permitAll()
                .antMatchers("/admin/**", "/**").hasAuthority("ADMIN_ROLE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout().logoutSuccessUrl("/").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder(passwordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username , password , enable from user where username=?")
                .authoritiesByUsernameQuery("SELECT username , role from user where username=?");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
