package com.sandroni.hexagonal.adapters.`in`.controllers.response

import com.sandroni.hexagonal.application.core.domain.Customer

data class CustomerResponse(
    val id: String,
    val name:String,
    val cpf: String,
    val address: AddressResponse,
    val isValidCPF: Boolean
){
    constructor(customer: Customer): this(
        id = customer.id!!,
        name = customer.name,
        cpf = customer.cpf,
        address = AddressResponse(customer.address!!),
        isValidCPF = customer.isValidCpf
    )
}
