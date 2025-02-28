package xyz.fiwka.ptmplace.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtPropertiesConfiguration {

    @Bean
    public JwtProperties jwtProperties(JwtProperties properties) {
        return properties;
    }

}
