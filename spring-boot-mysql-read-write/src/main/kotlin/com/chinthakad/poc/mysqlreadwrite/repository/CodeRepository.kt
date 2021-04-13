package com.chinthakad.poc.mysqlreadwrite.repository

import com.chinthakad.poc.mysqlreadwrite.model.CodeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CodeRepository : JpaRepository<CodeEntity, Int> {

}