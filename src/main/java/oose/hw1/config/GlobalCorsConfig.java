package oose.hw1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  //
                        .allowedOrigins("https://your-frontend-app.azurewebsites.net")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")  // 允许的请求头
                        .allowCredentials(true);  // 允许携带凭证（如 Cookies）
            }
        };
    }
}