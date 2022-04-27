package com.migle.expensetracker;

import com.migle.expensetracker.filters.AuthFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class ExpenseTrackerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseTrackerApiApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> filterRegistrationBean() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthFilter());
        // filter needs to be applied to protected components
        // urls other than login and register need to be protected

        registrationBean.addUrlPatterns("/api/categories/*");
        return registrationBean;
    }

    // allow cross-origin requests
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("http://localhost:5500");
        configuration.addAllowedOrigin("*"); // allow all
        configuration.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", configuration);
        registrationBean.setFilter(new CorsFilter(source));
        registrationBean.setOrder(0); // execute first
        return registrationBean;
    }
}
