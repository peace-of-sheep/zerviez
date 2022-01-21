package tech.futurizeme

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import kotlinx.serialization.json.Json
import tech.futurizeme.domain.Response
import tech.futurizeme.extension.ImTeapot

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {

    install(ContentNegotiation) {
        json(Json {
            isLenient = true
        })
    }

    routing {
        get {
            call.respond(Response(data = "ReqRes bootleg"))
        }

        get("/ping") {
            call.respond(Response(data = "pong"))
        }

        get("/coffee") {
            call.respond(HttpStatusCode.ImTeapot)
        }
    }
}
