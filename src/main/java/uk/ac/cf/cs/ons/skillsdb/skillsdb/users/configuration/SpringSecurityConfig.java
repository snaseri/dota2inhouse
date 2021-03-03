package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.configuration;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;


    /**
     * Configuration for what URLs can be accessed
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login")).and()
                .authorizeRequests()
                .antMatchers("/index").hasRole("USER")
                .antMatchers("/advert/**").hasRole("USER")
                .antMatchers("/course/create").hasRole("USER")
                .antMatchers("/courses/{id}").hasRole("USER")
                .antMatchers("/skill/{i}").hasRole("USER")
                .antMatchers("/discover" ).hasRole("USER")
                .antMatchers("/user/**" ).hasRole("USER")
                .antMatchers("/profile/**" ).hasRole("USER")

                .and().formLogin().defaultSuccessUrl("/search/")
                .loginPage("/login").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login").permitAll();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.css");
        web.ignoring().antMatchers("/*.js");
    }
}