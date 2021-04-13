package com.chinthakad.poc.mysqlreadwrite.service

import com.chinthakad.poc.mysqlreadwrite.model.CodeEntity
import com.chinthakad.poc.mysqlreadwrite.repository.CodeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.random.Random

/**
 *
 */
@Service
@Transactional(readOnly = true)
class CodeService {

    @Autowired
    lateinit var codeRepository: CodeRepository

    fun getCodes(): List<CodeEntity> {
        val c = codeRepository.findAll()
        return c;
    }

    @Transactional(readOnly = false)
    fun addCode() {
        val ce = CodeEntity(Random.nextInt())
        codeRepository.save(ce)
    }

}