package com.example.routs

import com.example.dao.user.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Route.userRouting() {
    route("users") {
        get {
            call.respond(FreeMarkerContent("user/indexUser.ftl", mapOf("users" to dao.allUsers())))
        }
        get("new") {
            call.respond(FreeMarkerContent("user/newUser.ftl", model = null))
        }
        post {
            val formParameters = call.receiveParameters()
            val firstname = formParameters.getOrFail("firstname")
            val surname = formParameters.getOrFail("surname")
            val birthday = formParameters.getOrFail("birthday")
            val user = dao.addNewUser(firstname, surname, birthday)
            call.respondRedirect("/users/${user?.id}")
        }
        get("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("user/showUser.ftl", mapOf("user" to dao.user(id))))
        }
        get("{id}/edit") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            call.respond(FreeMarkerContent("user/editUser.ftl", mapOf("user" to dao.user(id))))
        }
        post("{id}") {
            val id = call.parameters.getOrFail<Int>("id").toInt()
            val formParameters = call.receiveParameters()
            when (formParameters.getOrFail("_action")) {
                "update" -> {
                    val firstname = formParameters.getOrFail("firstname")
                    val surname = formParameters.getOrFail("surname")
                    val birthday = formParameters.getOrFail("birthday")
                    dao.editUser(id, firstname, surname, birthday)
                    call.respondRedirect("/users/$id")
                }
                "delete" -> {
                    dao.deleteUser(id)
                    call.respondRedirect("/users")
                }
            }
        }
    }
}
