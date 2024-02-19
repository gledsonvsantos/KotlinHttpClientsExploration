package com.example

import com.google.gson.GsonBuilder
import io.micronaut.http.HttpRequest
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Inject
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy
import java.net.URL


@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/demo")
class DemoController(
    private val dogBreedClient: DogBreedClient,
    @Client("https://dog.ceo") private val httpClient: HttpClient // Inicializa o cliente HTTP no construtor
) {
    private val gson = GsonBuilder().setPrettyPrinting().create()

//    @Inject
//    @field:Client("https://dog.ceo")
//    lateinit var httpClient: HttpClient // Outra forma de inicializar o cliente HTTP

    /**
     * Endpoint that returns a DogResponse.
     * Makes a request using the HttpClient library.
     * @return DogResponse or null if the request fails.
     */
    @Get("/")
    fun hello(): DogResponse? {
        // Request de forma imperativa
//        val response = requestOkHttp()

        // Request utilizando proxy
//        val response = requestOkHttpProxy()

        // Request utilizando a biblioteca Micronaut
        val response = requestHttpClient()
        return response
    }

    private fun requestHttpClient(): DogResponse? {
//        val client = HttpClient.create(URL("https://dog.ceo")) // Cria um cliente HTTP (outra forma de iniciar)
//        val request: HttpRequest<Any> = HttpRequest.GET("/api/breeds/image/random")
        val request: MutableHttpRequest<DogResponse>? = HttpRequest.GET<DogResponse>("/api/breeds/image/random")
//        val body = httpClient.toBlocking().retrieve(request) //retorna body como string
        val dogResponse = httpClient.toBlocking().retrieve(request, DogResponse::class.java) //retorna body como objeto
//        client.close() // Fecha o cliente
        return dogResponse
    }

    @Get("/random-image")
    fun getRandomDogImage(): String {
        // Request de forma declativa do Micronaut
        return dogBreedClient.getRandomDogImage()
    }


    private fun requestOkHttp(): DogResponse? {
        // Cria uma instância do cliente OkHttp
        val client = OkHttpClient()

        // Cria uma requisição GET
        val request = Request.Builder()
            .url("https://dog.ceo/api/breeds/image/random")
            .build()

        // Executa a requisição e lida com a resposta
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Erro inesperado: $response")

            // Pega o corpo da resposta
            val body = response.body?.string()

            // Converte o corpo da resposta em um objeto (serialização)
            val dogResponse = gson.fromJson(body, DogResponse::class.java)

            return dogResponse
        }
    }

    private fun requestOkHttpProxy(): DogResponse? {
        // Configura o endereço e a porta do proxy
        val proxyAddress = InetSocketAddress("127.0.0.1", 3128)

        //23:59:11.985 [io-executor-thread-1] ERROR i.m.http.server.RouteExecutor - Unexpected error occurred: Failed to connect to /127.0.0.1:1111

        // Cria uma instância de Proxy
        val proxy = Proxy(Proxy.Type.HTTP, proxyAddress)

        // Cria uma instância do cliente OkHttp
        val client = OkHttpClient.Builder()
            .proxy(proxy)
            .build()

        // Cria uma requisição GET
        val request = Request.Builder()
            .url("https://dog.ceo/api/breeds/image/random")
            .build()

        // Executa a requisição e lida com a resposta
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Erro inesperado: $response")

            // Pega o corpo da resposta
            val body = response.body?.string()

            // Converte o corpo da resposta em um objeto (serialização)
            val dogResponse = gson.fromJson(body, DogResponse::class.java)

            return dogResponse
        }
    }

}




