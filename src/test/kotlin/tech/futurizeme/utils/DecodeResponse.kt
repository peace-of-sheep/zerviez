package tech.futurizeme.utils

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import tech.futurizeme.domain.Response

fun decodeResponse(content: String?): Response? {
    return content?.let { stringJson ->
        Json.decodeFromString<Response>(stringJson)
    }
}