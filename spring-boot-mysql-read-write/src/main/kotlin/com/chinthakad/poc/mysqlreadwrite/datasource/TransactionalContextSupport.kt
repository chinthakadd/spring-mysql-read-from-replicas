package com.chinthakad.poc.mysqlreadwrite.datasource

import com.chinthakad.poc.mysqlreadwrite.model.TransactionMode
import org.springframework.core.NamedThreadLocal
import kotlin.concurrent.getOrSet

/**
 * Thread Local Object that is custom built to hold the Transaction Mode.
 */
class TransactionalContextSupport {

    companion object {
        var transactionModeTl: ThreadLocal<TransactionMode> = NamedThreadLocal("TransactionMode")

        fun setTransactionMode(mode: TransactionMode) {
            transactionModeTl.set(mode)
        }

        fun getTransactionMode(): TransactionMode {
            return transactionModeTl.getOrSet { return TransactionMode.READ_WRITE }
        }

        fun clear() {
            transactionModeTl.remove()
        }
    }

}