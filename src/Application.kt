package com.example

import com.example.controller.TestController
import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.response.*
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.http.ContentType
import io.ktor.routing.get
import io.netty.handler.codec.DefaultHeaders

fun Application.main() {
//    val server = embeddedServer(Netty, port = 8080) {
    install(io.ktor.features.DefaultHeaders)
    install(CallLogging)
    routing {
        get("/") {
            val testController = TestController()
            call.respondText(testController.hello(), ContentType.Text.Plain)
        }
        get("/demo") {
            call.respondText("HELLO WORLD!")
        }
    }
//    }
//    server.start(wait = true)
}
