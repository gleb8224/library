package com.example.models

import org.jetbrains.exposed.sql.*

data class User(
    val id: Int,
    val firstname: String,
    val surname: String,
    val birthday: String
)

object Users : Table() {
    val id = integer("id")
    val firstname = varchar("firstname", 32)
    val surname = varchar("surname", 32)
    val birthday = text("birthday")
}