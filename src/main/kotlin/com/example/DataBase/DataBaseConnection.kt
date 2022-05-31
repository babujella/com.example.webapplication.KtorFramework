package com.example.DataBase

import me.liuwj.ktorm.database.Database

object DataBaseConnection {
    val url="jdbc:mysql://localhost:3306/employeedetails"
    val driver="com.mysql.cj.jdbc.Driver"
    val user="root"
    val password="root"
    val database= Database.connect(url,driver, user, password)
}