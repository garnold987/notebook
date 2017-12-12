package org.iwatllc.notebook.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.iwatllc.notebook.model"})
@EnableJpaRepositories(basePackages = {"org.iwatllc.notebook.infrastructure"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
