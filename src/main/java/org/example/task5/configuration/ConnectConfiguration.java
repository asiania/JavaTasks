package org.example.task5.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectConfiguration {

    @Bean
    public HikariDataSource dataSource() {
        HikariConfig  config = new HikariConfig ();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/users");
        config.setUsername("postgres");
        config.setPassword("asiania5");
        config.setConnectionTimeout(50000);
        config.setMaximumPoolSize(20);

        return new HikariDataSource(config);
    }

}
