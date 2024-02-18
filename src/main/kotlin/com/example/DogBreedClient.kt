package com.example

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

//Declarativa
@Client("https://dog.ceo")
interface DogBreedClient {

    @Get("/api/breeds/image/random")
    fun getRandomDogImage(): String
}