package com.chinthakad.poc.mysqlreadwrite.controller

import com.chinthakad.poc.mysqlreadwrite.model.CodeEntity
import com.chinthakad.poc.mysqlreadwrite.service.CodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/code")
class CodeController {

    @Autowired
    lateinit var codeService: CodeService

    @GetMapping
    fun getCodesFromReplica(): List<CodeEntity>{
        return codeService.getCodes()
    }

    @PostMapping
    fun addNewCode(){
        codeService.addCode()
    }
}