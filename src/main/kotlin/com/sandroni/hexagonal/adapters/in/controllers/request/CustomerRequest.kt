package com.sandroni.hexagonal.adapters.`in`.controllers.request

import jakarta.validation.constraints.NotBlank

data class CustomerRequest(
    @field:NotBlank(message = "Name is required")
    val name: String,

    @field:NotBlank(message = "Email is required")
    val cpf: String,

    @field:NotBlank(message = "Address is required")
    val zipcode: String,
)
