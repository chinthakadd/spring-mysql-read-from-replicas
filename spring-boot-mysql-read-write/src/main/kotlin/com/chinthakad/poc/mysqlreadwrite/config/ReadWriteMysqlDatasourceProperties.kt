package com.chinthakad.poc.mysqlreadwrite.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * This was the trickiest part with Spring/ Kotlin. Data classes with ConfigurationProperties annotation
 * does not work seamlessly. There are many limitations including not being able to use nested objects.
 * Required <code>@ConfigurationPropertiesScan</code> and <code>@ConstructorBinding</code> for this to work.
 */
@ConfigurationProperties(prefix = "app.datasource.leader")
data class  ReadWriteMysqlDatasourceProperties @ConstructorBinding constructor(
        val url: String,
        val username: String,
        val password: String
)

@ConfigurationProperties(prefix = "app.datasource.follower")
data class  ReadOnlyMysqlDatasourceProperties @ConstructorBinding constructor (
        val url: String,
        val username: String,
        val password: String
)
