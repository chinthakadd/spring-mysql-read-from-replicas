package com.chinthakad.poc.mysqlreadwrite.datasource

import com.chinthakad.poc.mysqlreadwrite.getLogger
import com.chinthakad.poc.mysqlreadwrite.model.TransactionMode
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

/**
 * Custom AOP Advice that runs before Spring's Transactional Advice and set the TransactionMode based on the
 * Transactional Annotation defined in the Service Class.
 *
 *
 * @Order(1) annotation makes this higher in priority than Spring's Transaction Advice.
 */
@Order(1)
@Aspect
@Component
class TransactionModeInspectionAspect {
    companion object {
        @Suppress("JAVA_CLASS_ON_COMPANION")
        private val logger = getLogger(javaClass.enclosingClass)
    }

    @Before("execution(* (@org.springframework.transaction.annotation.Transactional *).*(..))")
    fun setTransactionMode(joinPoint: JoinPoint) {
        val methodSignature: MethodSignature = joinPoint.signature as MethodSignature
        val txnAnno = methodSignature.method.getAnnotation(Transactional::class.java)
        var txnMode = TransactionMode.READ_ONLY
        if (txnAnno != null && !txnAnno.readOnly) {
            txnMode = TransactionMode.READ_WRITE
        }
        logger.info("Transaction Mode: {}", txnMode)
        TransactionalContextSupport.setTransactionMode(txnMode)
    }

    @After("execution(* (@org.springframework.transaction.annotation.Transactional *).*(..))")
    fun clearTransactionMode(joinPoint: JoinPoint) {
        TransactionalContextSupport.clear()
    }
}