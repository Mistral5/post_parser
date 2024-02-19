package com.example.post_parser.data.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json

object HttpClientFactory {
  val httpClient: HttpClient by lazy {
    HttpClient(OkHttp) {
      install(ContentNegotiation) {
        json()
      }

      defaultRequest {
        contentType(ContentType.Application.Json)
        url("https://jsonplaceholder.typicode.com/")
      }

      install(HttpRequestRetry) {
        retryOnServerErrors(maxRetries = 5)
      }

      install(HttpTimeout) {
        requestTimeoutMillis = 5000
      }
      expectSuccess = true

      HttpResponseValidator {
        handleResponseExceptionWithRequest { exception, request ->
          val clientException = exception as? ClientRequestException ?: return@handleResponseExceptionWithRequest
          val exceptionResponse = clientException.response
          if (exceptionResponse.status == HttpStatusCode.NotFound) {
            val exceptionResponseText = exceptionResponse.bodyAsText()
//            throw MissingPageException(exceptionResponse, exceptionResponseText)
          }
        }
      }
    }
  }
}
