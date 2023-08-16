package com.example.dao.user

import com.example.models.User
import com.example.models.Users
import com.example.plugins.dbQuery
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class UserDAOFacadeImpl : UserDAOFacade {
    private fun resultRowToUser(row: ResultRow) = User(
        id = row[Users.id],
        firstname = row[Users.firstname],
        surname = row[Users.surname],
        birthday = row[Users.birthday]
    )

    override suspend fun allUsers(): List<User> = dbQuery {
        Users.selectAll().map(::resultRowToUser)
    }

    override suspend fun user(id: Int): User? = dbQuery {
        Users
            .select { Users.id eq id}
            .map(::resultRowToUser)
            .singleOrNull()
    }

    override suspend fun addNewUser(
        firstname: String,
        surname: String,
        birthday: String
    ): User? = dbQuery {
        val insertStatement = Users.insert {
            it[Users.firstname] = firstname
            it[Users.surname] = surname
            it[Users.birthday] = birthday
        }
        insertStatement.resultedValues?.singleOrNull()?.let(::resultRowToUser)
    }

    override suspend fun editUser(
        id: Int,
        firstname: String,
        surname: String,
        birthday: String
    ): Boolean = dbQuery {
        Users.update({ Users.id eq id }) {
            it[Users.firstname] = firstname
            it[Users.surname] = surname
            it[Users.birthday] = birthday
        } > 0
    }

    override suspend fun deleteUser(id: Int): Boolean = dbQuery {
        Users.deleteWhere { Users.id eq id } > 0
    }
}

val dao: UserDAOFacade = UserDAOFacadeImpl().apply {
    runBlocking {
    }
}