package com.chinthakad.poc.mysqlreadwrite.datasource

import com.chinthakad.poc.mysqlreadwrite.getLogger
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

/**
 * Implementation of AbstractRoutingDataSource that implements #determineCurrentLookupKey based on
 * <code>TransactionMode</code>
 */
open class ReadWriteRoutingDatasource : AbstractRoutingDataSource() {

    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    override fun determineCurrentLookupKey(): Any? {
        val datasourceType = TransactionalContextSupport.getTransactionMode()
        logger.info("Datasource Type:" + datasourceType)
        return datasourceType
    }
}

