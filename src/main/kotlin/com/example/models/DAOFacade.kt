package com.example.models

import com.example.DataBase.DataBaseConnection
import com.example.dao.Employees
import io.ktor.utils.io.core.*
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.dsl.insert
import me.liuwj.ktorm.dsl.update

interface DAOFacade:Closeable {
    fun createEmployee(name:String, email:String, city:String,role:String)
    fun updateEmployee(id:Int, name:String, email:String, city:String,role:String)
    /* fun deleteEmployee(id:Int)
   fun getEmployee(id:Int): Employee?
    fun getAllEmployees(): List<Employee>*/
}
class  DAOFacadeDatabase:DAOFacade {
    val data = DataBaseConnection.database

    override fun createEmployee(name: String, email: String, city: String, role: String) {
        data.insert(Employees) {
            set(it.name, name)
            set(it.email, email)
            set(it.city, city)
            set(it.role, role)

        }
    }
    override fun updateEmployee(id: Int, name: String, email: String, city: String, role: String) {
        data.update(Employees) {
            set(it.name, name)
            set(it.email, email)
            set(it.city, city)
            set(it.role, role)
            where {
                it.id eq id
            }
        }
    }
    /*  override fun deleteEmployee(id: Int) {
         data.delete(Employees){
             it.id eq id
         }
      }
      override fun getEmployee(id: Int): Employee? {
          val  database=data.from(Employees).select()
          for (daTa in database) {
              println("${daTa[Employees.id]} and ${daTa[Employees.name]} ${daTa[Employees.email]} ${daTa[Employees.city]} ${daTa[Employees.role]}")
          }
      }
      override fun getAllEmployees(): List<Employee> {
          TODO("Not yet implemented")
          val  database=data.from(Employees).select()
          for (daTa in database) {
              println("${daTa[Employees.id]} and ${daTa[Employees.name]} ${daTa[Employees.email]} ${daTa[Employees.city]} ${daTa[Employees.role]}")
          }
      }*/
    override fun close() {
        TODO("Not yet implemented")
    }
}