package com.example.dao.author

import com.example.models.*

interface AuthorDAOFacade {
    suspend fun allAuthors(): List<Author>
    suspend fun author(id: Int): Author?
    suspend fun addNewAuthor(firstname: String, surname: String, patronymic: String, birthday: String): Author?
    suspend fun editAuthor(id: Int, firstname: String, surname: String, patronymic: String, birthday: String): Boolean
    suspend fun deleteAuthor(id: Int): Boolean
}