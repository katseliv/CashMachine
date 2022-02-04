package com.dataart.cashmachine.security;

import com.dataart.cashmachine.db.provider.CardSecurityProvider;
import com.dataart.cashmachine.security.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CardSecurityProvider cardSecurityProvider;

    @Autowired
    public SecurityConfiguration(CardSecurityProvider cardSecurityProvider) {
        this.cardSecurityProvider = cardSecurityProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        var daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        auth.userDetailsService(userDetailsServiceBean());
        auth.authenticationProvider(daoAuthenticationProvider);
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() {
        return new UserDetailsServiceImpl(cardSecurityProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private CorsConfigurationSource corsConfigurationSource() {
        final var urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final var config = new CorsConfiguration();
        config.setAllowCredentials(true); //разрешаем передавать ключи
        config.addAllowedOrigin("*"); // разрешаем запросы с любого домена
        config.addAllowedHeader("*"); // разрешаем передавать любые заголовки
        for (var method: List.of(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.HEAD))
            config.addAllowedMethod(method); // разрешаем http-методы

        config.addExposedHeader("*"); // разрешаем возвращать все заголовки
        urlBasedCorsConfigurationSource.registerCorsConfiguration("*", config); // разрешаем на любой API
        return urlBasedCorsConfigurationSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/card") //Перенаправление на главную страницу после успешного входа
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/cashmachine/logout")
//                //.logoutSuccessUrl("")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/card")
//                .not().fullyAuthenticated()
//                .antMatchers("/**").permitAll()
//                .anyRequest().authenticated()
//                ;

//        http
//                .cors().configurationSource(corsConfigurationSource()).and()// какие сайты вообще смогут обращаться к приложению, без нее 403
//                .csrf().disable() // защита от Cross-Site Request Forgery
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
////                .deleteCookies("JSESSIONID")
//                .and()
//
////                .successHandler(new HealthtechSuccessHandler(userSecurityProvider, profileMapper))
////                .failureHandler(new HealthtechFailureHandler())
//                .authorizeRequests()
//                .mvcMatchers(HttpMethod.POST, "/login").not().permitAll()//.authenticated()
//                .anyRequest().permitAll()/*.fullyAuthenticated()*/
//                .and()
////                .exceptionHandling().accessDeniedHandler(new HealthtechAccessDeniedHandler())
////                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                ;

//        http
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                //Доступ только для не зарегистрированных пользователей
//                .antMatchers("/registration").not().fullyAuthenticated()
//                //Доступ только для пользователей с ролью Администратор
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/news").hasRole("USER")
//                //Доступ разрешен всем пользователей
////                .antMatchers("/", "/resources/**").permitAll()
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and()
//                //Настройка для входа в систему
//                .formLogin()
//                .loginPage("/login")
//                //Перенарпавление на главную страницу после успешного входа
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");

        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

}
