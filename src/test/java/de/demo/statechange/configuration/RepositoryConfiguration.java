package de.demo.statechange.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"de.demo.statechange.domain"})
@EnableJpaRepositories(basePackages = {"de.demo.statechange.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
