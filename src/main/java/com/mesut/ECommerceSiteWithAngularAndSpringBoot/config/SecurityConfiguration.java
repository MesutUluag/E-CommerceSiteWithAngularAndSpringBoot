package com.mesut.ECommerceSiteWithAngularAndSpringBoot.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
         // protect endpoint /api/orders
        http.authorizeRequests()
                .antMatchers("/api/orders/**")
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();

        // add cors filters
        http.cors();

        // add a non-empty response body for 401
        Okta.configureResourceServer401ResponseBody(http);

        // disable CSRF because we are not using cookies for session tracking
        http.csrf().disable();
    }
}
