package com.example

import io.micronaut.serde.annotation.Serdeable

@Serdeable.Serializable
@Serdeable.Deserializable
data class DogResponse(
    val message: String,
    val status: String
)