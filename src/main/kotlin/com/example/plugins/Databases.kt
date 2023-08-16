package com.example.plugins

import com.example.models.Authors
import com.example.models.Books
import com.example.models.Users
import io.ktor.server.application.*
import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabases() {
    val database = Database.connect(
        url = "jdbc:postgresql://localhost:5432/postgres",
        user = "postgres",
        driver = "org.postgresql.Driver",
        password = "root"
    )
}

suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }