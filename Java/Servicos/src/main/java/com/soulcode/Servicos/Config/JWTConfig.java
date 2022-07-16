package com.soulcode.Servicos.Config;

import com.soulcode.Servicos.Security.JWTAuthenticationFilter;
import com.soulcode.Servicos.Security.JWTAuthorizationFilter;
import com.soulcode.Servicos.Services.AuthUserDetailService;
import com.soulcode.Servicos.Util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@EnableWebSecurity
public class JWTConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthUserDetailService authUserDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configura o UserDetailsService para que o Spring Security possa buscar os dados do usuário
        auth.userDetailsService(authUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // habilita o cors e desabilita o csrf
        http.cors().and().csrf().disable();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtils)); //adiciona o filtro de autenticação
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtils)); //adiciona o filtro de autorização

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll() //permitir acesso ao endpoint de autenticação
     //           .antMatchers(HttpMethod.GET, "/servicos/**").permitAll() //permitir acesso ao endpoint de autorização
                .anyRequest().authenticated(); //todos os outros endpoints precisam estar autenticados

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //não cria sessão de usuário

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration(); //cria uma configuração de cors
        configuration.setAllowedMethods(List.of(
                HttpMethod.GET.name(),
                HttpMethod.PUT.name(),
                HttpMethod.POST.name(),
                HttpMethod.DELETE.name()
        )); //permitir todos os métodos
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //adiciona a configuração de cors a fonte de configuração
        source.registerCorsConfiguration("/**", configuration.applyPermitDefaultValues());
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
