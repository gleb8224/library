package com.example.models

import org.jetbrains.exposed.sql.*

data class Book(
    val id: Int,
    val name: String,
    val genre: String,
    val publishdate: String,
    val authorid: Int
)

object Books : Table() {
    val id = integer("id")
    val name = varchar("name", 255)
    val genre = varchar("genre", 255)
    val publishdate = varchar("publishdate", 255)
    val authorid = integer("authorid")
}