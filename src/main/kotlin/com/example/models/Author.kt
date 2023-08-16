package com.example.models

import org.jetbrains.exposed.sql.*

data class Author(
    val id: Int,
    val firstname: String,
    val surname: String,
    val patronymic: String,
    val birthday: String
)

object Authors : Table() {
    val id = integer("id")
    val firstname = varchar("firstname", 255)
    val surname = varchar("surname", 255)
    val patronymic = varchar("patronymic", 255)
    val birthday = varchar("birthday", 255)
}