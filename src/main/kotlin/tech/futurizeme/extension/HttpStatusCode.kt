package tech.futurizeme.extension

import io.ktor.http.*

val HttpStatusCode.Companion.ImTeapot: HttpStatusCode
    get() = HttpStatusCode(418, "I'm a teapot")