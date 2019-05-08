package eco.ouarhou.ecommerce.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource datasource;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.jdbcAuthentication().dataSource(datasource)
         .usersByUsernameQuery("select username as principal,password as credentials,active from users where username=?")
         .authoritiesByUsernameQuery("select username as principal,role as role from users_roles where username=?")
         .rolePrefix("ROLE_").passwordEncoder(bCryptPasswordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/").permitAll();
        http.authorizeRequests().antMatchers("/SupprimerClient","/touslesclients","/managerProduits").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/","/WebProducts","/createAccount").permitAll();
        http.authorizeRequests().antMatchers("/ConfirmerPanier","/voirPanier","/ajoutPanier").hasRole("CLIENT");
        http.exceptionHandling().accessDeniedPage("/403");
    }
}
