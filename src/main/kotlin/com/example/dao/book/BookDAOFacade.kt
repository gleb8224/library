package com.example.dao.book

import com.example.models.*

interface BookDAOFacade {
    suspend fun allBooks(): List<Book>
    suspend fun book(id: Int): Book?
    suspend fun addNewBook(name: String, genre: String, publishdate: String, authorid: Int): Book?
    suspend fun editBook(id: Int, name: String, genre: String, publishdate: String,  authorid: Int): Boolean
    suspend fun deleteBook(id: Int): Boolean
}