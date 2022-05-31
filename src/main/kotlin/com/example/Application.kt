package com.example

import com.example.models.DAOFacadeDatabase
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.security.Policy
import kotlin.text.get

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureTemplating()
        routing {
            route("/"){
                get{
                    call.respond(FreeMarkerContent("index.ftl", mapOf("Employees" to it.)))
                }
            }
            route("/employee"){
                get {
                    val action = (call.request.queryParameters["action"] ?: "new")
                    when(action){
                        "new" -> call.respond(FreeMarkerContent("employee.ftl",
                            mapOf("action" to action)))
                        "edit" -> {
                            val id = call.request.queryParameters["id"]
                            if(id != null){
                                call.respond(FreeMarkerContent("employee.ftl")
                            }
                        }
                    }
                }
              /*  post{
                    val postParameters: Policy.Parameters = call.receiveParameters()
                    val action = postParameters["action"] ?: "new"
                    when(action){
                        "new" -> dao.createEmployee(postParameters["name"] ?: "", postParameters["email"] ?: "", postParameters["city"] ?: "")
                        "edit" ->{
                            val id = postParameters["id"]
                            if(id != null)
                                dao.updateEmployee(id.toInt(), postParameters["name"] ?: "", postParameters["email"] ?: "", postParameters["city"] ?: "")
                        }
                    }
                    call.respond(FreeMarkerContent("index.ftl", mapOf("employees" to dao.getAllEmployees())))
                }
            }
            route("/delete"){
                get{
                    val id = call.request.queryParameters["id"]
                    if(id != null){
                        dao.deleteEmployee(id.toInt())
                        call.respond(FreeMarkerContent("index.ftl", mapOf("employees" to dao.getAllEmployees())))
                    }
                }
            }
        }*/
    }.start(wait = true)
}
