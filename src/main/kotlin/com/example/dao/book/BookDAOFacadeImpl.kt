package com.example.dao.book

import com.example.models.*
import com.example.plugins.dbQuery
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class BookDAOFacadeImpl : BookDAOFacade {
    private fun resultRowToBook(row: ResultRow) = Book(
        id = row[Books.id],
        name = row[Books.name],
        genre = row[Books.genre],
        publishdate = row[Books.publishdate],
        authorid = row[Books.authorid]
    )

    override suspend fun allBooks(): List<Book> = dbQuery {
        Books.selectAll().map(::resultRowToBook)
    }

    override suspend fun book(id: Int): Book? = dbQuery {
        Books
            .select { Books.id eq id}
            .map(::resultRowToBook)
            .singleOrNull()
    }

    override suspend fun addNewBook(
        name: String,
        genre: String,
        publishdate: String,
        authorid: Int
    ): Book? = dbQuery {
        val insertStatement = Books.insert {
            it[Books.name] = name
            it[Books.genre] = genre
            it[Books.publishdate] = publishdate
            it[Books.authorid] = authorid
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToBook)
    }

    override suspend fun editBook(
        id: Int,
        name: String,
        genre: String,
        publishdate: String,
        authorid: Int
    ): Boolean = dbQuery {
        Books.update({ Books.id eq id }) {
            it[Books.name] = name
            it[Books.genre] = genre
            it[Books.publishdate] = publishdate
            it[Books.authorid] = authorid
        } > 0
    }

    override suspend fun deleteBook(id: Int): Boolean = dbQuery {
        Books.deleteWhere { Books.id eq id } > 0
    }
}

val dao: BookDAOFacade = BookDAOFacadeImpl().apply {
    runBlocking {
    }
}