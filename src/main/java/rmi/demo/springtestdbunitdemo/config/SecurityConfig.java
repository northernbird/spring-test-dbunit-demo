package rmi.demo.springtestdbunitdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${basicauth.username:user}")
  private String basicAuthUserName;

  /*
   * In Spring Security 5, the default is DelegatingPasswordEncoder,
   * which required Password Storage Format.
   * {noop} : NoOpPasswordEncoder (for plain text passwords)
   */
  @Value("${basicauth.password:{noop}password}")
  private String basicAuthPassword;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/demo").authenticated()
        .and()
        .httpBasic()
        .and()
        .csrf()
        .disable();;
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser(basicAuthUserName).password(basicAuthPassword)
        .authorities("ROLE_USER");
  }


}
