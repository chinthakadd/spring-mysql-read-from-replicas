package com.chinthakad.poc.mysqlreadwrite

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun getLogger(forClass: Class<*>): Logger =
        LoggerFactory.getLogger(forClass)