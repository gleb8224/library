package com.example.dao.author

import com.example.models.*
import com.example.plugins.dbQuery
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class AuthorDAOFacadeImpl : AuthorDAOFacade {
    private fun resultRowToAuthor(row: ResultRow) = Author(
        id = row[Authors.id],
        firstname = row[Authors.firstname],
        surname = row[Authors.surname],
        patronymic = row[Authors.patronymic],
        birthday = row[Authors.birthday]
    )

    override suspend fun allAuthors(): List<Author> = dbQuery {
        Authors.selectAll().map(::resultRowToAuthor)
    }

    override suspend fun author(id: Int): Author? = dbQuery {
        Authors
            .select { Authors.id eq id }
            .map(::resultRowToAuthor)
            .singleOrNull()
    }

    override suspend fun addNewAuthor(
        firstname: String,
        surname: String,
        patronymic: String,
        birthday: String
    ): Author? = dbQuery {
        val insertStatement = Authors.insert {
            it[Authors.firstname] = firstname
            it[Authors.surname] = surname
            it[Authors.patronymic] = patronymic
            it[Authors.birthday] = birthday
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToAuthor)
    }

    override suspend fun editAuthor(
        id: Int,
        firstname: String,
        surname: String,
        patronymic: String,
        birthday: String
    ): Boolean = dbQuery {
        Authors.update({ Authors.id eq id }) {
            it[Authors.firstname] = firstname
            it[Authors.surname] = surname
            it[Authors.patronymic] = patronymic
            it[Authors.birthday] = birthday
        } > 0
    }

    override suspend fun deleteAuthor(id: Int): Boolean = dbQuery {
        Authors.deleteWhere { Authors.id eq id } > 0
    }
}

val dao: AuthorDAOFacade = AuthorDAOFacadeImpl().apply {
    runBlocking {
    }
}