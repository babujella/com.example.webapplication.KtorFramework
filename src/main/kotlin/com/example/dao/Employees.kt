package com.example.dao

import me.liuwj.ktorm.schema.Table
import me.liuwj.ktorm.schema.int
import me.liuwj.ktorm.schema.varchar

object Employees : Table<Nothing>("emp"){
    val id=int("id").primaryKey()
    val name=varchar("name")
    val email=varchar("email")
    val city=varchar("city")
    val role=varchar("role")
}