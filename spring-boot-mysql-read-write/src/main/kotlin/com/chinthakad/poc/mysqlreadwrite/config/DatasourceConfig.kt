package com.chinthakad.poc.mysqlreadwrite.config

import com.chinthakad.poc.mysqlreadwrite.datasource.ReadWriteRoutingDatasource
import com.chinthakad.poc.mysqlreadwrite.model.TransactionMode
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.sql.DataSource


@Configuration
class DatasourceConfig{

    @Autowired
    lateinit var readWriteConfig: ReadWriteMysqlDatasourceProperties

    @Autowired
    lateinit var readOnlyConfig: ReadOnlyMysqlDatasourceProperties

    fun readWriteDataSource(): DataSource {
        val hikariConfig = HikariConfig()
        hikariConfig.jdbcUrl = readWriteConfig.url
        hikariConfig.password = readWriteConfig.password
        hikariConfig.username = readWriteConfig.username
        return HikariDataSource(hikariConfig)
    }

    fun readOnlyDataSource(): DataSource {
        val hikariConfig = HikariConfig()
        hikariConfig.jdbcUrl = readOnlyConfig.url
        hikariConfig.password = readOnlyConfig.password
        hikariConfig.username = readOnlyConfig.username
        return HikariDataSource(hikariConfig)
    }


    @Bean
    fun actualDataSource(): ReadWriteRoutingDatasource {
        val routingDataSource = ReadWriteRoutingDatasource()
        val dataSourceMap: MutableMap<Any, Any> = HashMap()
        dataSourceMap[TransactionMode.READ_WRITE] = readWriteDataSource()
        dataSourceMap[TransactionMode.READ_ONLY] = readOnlyDataSource()
        routingDataSource.setTargetDataSources(dataSourceMap)
        return routingDataSource
    }

}