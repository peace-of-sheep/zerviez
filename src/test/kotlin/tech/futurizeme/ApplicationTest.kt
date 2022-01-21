package tech.futurizeme

import io.ktor.http.*
import io.ktor.application.*
import kotlin.test.*
import io.ktor.server.testing.*
import tech.futurizeme.extension.ImTeapot
import tech.futurizeme.utils.decodeResponse

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication(Application::module) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())

                decodeResponse(response.content)?.apply {
                    assertEquals("ReqRes bootleg", data)
                }
            }
        }
    }

    @Test
    fun testPing() {
        withTestApplication(Application::module) {
            handleRequest(HttpMethod.Get, "/ping").apply {
                assertEquals(HttpStatusCode.OK, response.status())

                decodeResponse(response.content)?.apply {
                    assertEquals("pong", data)
                }
            }
        }
    }

    @Test
    fun testCoffee() {
        withTestApplication(Application::module) {
            handleRequest(HttpMethod.Get, "/coffee").apply {
                assertEquals(HttpStatusCode.ImTeapot, response.status())
            }
        }
    }
}