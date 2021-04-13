package com.chinthakad.poc.mysqlreadwrite.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "code")
open class CodeEntity {

    constructor(code: Int) {
        this.code = code
    }

    constructor()

    @Id
    open var code: Int = 0

    override fun toString(): String {
        return "CodeEntity(code='$code')"
    }



}