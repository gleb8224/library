package com.example.routs

import com.example.dao.book.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.bookRouting() {
    route("books") {
        get {
            call.respond(FreeMarkerContent("book/indexBook.ftl", mapOf("books" to dao.allBooks())))
        }
        get("new") {
            call.respond(FreeMarkerContent("book/newBook.ftl", model = null))
        }
        post {
            val formParameters = call.receiveParameters()
            val name = formParameters.getOrFail("name")
            val genre = formParameters.getOrFail("genre")
            val publishdate = formParameters.getOrFail("publishdate")
            val authorid = formParameters.getOrFail<Int>("authorid").toInt()
            val book = dao.addNewBook(name, genre, publishdate, authorid)
            call.respondRedirect("/books/${book?.id}")
        }
        get("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("book/showBook.ftl", mapOf("book" to dao.book(id))))
        }
        get("{id}/edit") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("book/editBook.ftl", mapOf("book" to dao.book(id))))
        }
        post("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val formParameters = call.receiveParameters()
            when (formParameters.getOrFail("_action")) {
                "update" -> {
                    val name = formParameters.getOrFail("name")
                    val genre = formParameters.getOrFail("genre")
                    val publishdate = formParameters.getOrFail("publishdate")
                    val authorid = formParameters.getOrFail<Int>("authorid").toInt()
                    dao.editBook(id, name, genre, publishdate, authorid)
                    call.respondRedirect("/books/$id")
                }
                "delete" -> {
                    dao.deleteBook(id)
                    call.respondRedirect("/books")
                }
            }
        }
    }
}
