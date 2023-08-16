package com.example.dao.user

import com.example.models.User

interface UserDAOFacade {
    suspend fun allUsers(): List<User>
    suspend fun user(id: Int): User?
    suspend fun addNewUser(firstname: String, surname: String, birthday: String): User?
    suspend fun editUser(id: Int, firstname: String, surname: String, birthday: String): Boolean
    suspend fun deleteUser(id: Int): Boolean
}