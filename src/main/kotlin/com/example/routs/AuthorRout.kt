package com.example.routs

import com.example.dao.author.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.authorRouting() {
    route("authors") {
        get {
            call.respond(FreeMarkerContent("author/indexAuthor.ftl", mapOf("authors" to dao.allAuthors())))
        }
        get("new") {
            call.respond(FreeMarkerContent("author/newAuthor.ftl", model = null))
        }
        post {
            val formParameters = call.receiveParameters()
            val firstname = formParameters.getOrFail("firstname")
            val surname = formParameters.getOrFail("surname")
            val patronymic = formParameters.getOrFail("patronymic")
            val birthday = formParameters.getOrFail("birthday")
            val author = dao.addNewAuthor(firstname, surname, patronymic, birthday)
            call.respondRedirect("/authors/${author?.id}")
        }
        get("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("author/showAuthor.ftl", mapOf("author" to dao.author(id))))
        }
        get("{id}/edit") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("author/editAuthor.ftl", mapOf("author" to dao.author(id))))
        }
        post("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val formParameters = call.receiveParameters()
            when (formParameters.getOrFail("_action")) {
                "update" -> {
                    val firstname = formParameters.getOrFail("firstname")
                    val surname = formParameters.getOrFail("surname")
                    val patronymic = formParameters.getOrFail("patronymic")
                    val birthday = formParameters.getOrFail("birthday")
                    dao.editAuthor(id, firstname, surname, patronymic, birthday)
                    call.respondRedirect("/authors/$id")
                }
                "delete" -> {
                    dao.deleteAuthor(id)
                    call.respondRedirect("/authors")
                }
            }
        }
    }
}
