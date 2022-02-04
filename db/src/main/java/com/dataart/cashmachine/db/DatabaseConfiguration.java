package com.dataart.cashmachine.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {"com.dataart.cashmachine.db.entity"})
@EnableJpaRepositories(basePackages = "com.dataart.cashmachine.db.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
