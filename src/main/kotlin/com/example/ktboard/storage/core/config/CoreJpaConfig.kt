package com.example.ktboard.storage.core.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["com.example.ktboard"])
@EnableJpaRepositories(basePackages = ["com.example.ktboard"])
class CoreJpaConfig {
}