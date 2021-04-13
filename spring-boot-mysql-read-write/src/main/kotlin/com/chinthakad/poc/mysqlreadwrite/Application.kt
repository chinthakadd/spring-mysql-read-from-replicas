package com.chinthakad.poc.mysqlreadwrite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class MysqlreadwriteApplication

fun main(args: Array<String>) {
	runApplication<MysqlreadwriteApplication>(*args)
}
