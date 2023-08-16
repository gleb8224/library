package com.example.plugins

import com.example.routs.authorRouting
import com.example.routs.bookRouting
import com.example.routs.userRouting
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondRedirect("library")
        }
        route("library") {
            get {
                call.respond(FreeMarkerContent("main.ftl", model = null))
            }
        }
        userRouting()
        authorRouting()
        bookRouting()
    }
}
