package com.sandroni.hexagonal.adapters.out.repository.entity

import com.sandroni.hexagonal.application.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId


@Document(collection = "customers")
data class CustomerEntity(
    @MongoId val id: String?,
    val name: String,
    val address: AddressEntity,
    val cpf: String,
    val isValidCpf: Boolean
){

    constructor(customer: Customer) : this(
        customer.id,
       customer.name,
        AddressEntity(customer.address!!),
         customer.cpf,
         customer.isValidCpf
    )

    fun toCustomer()=
        Customer(
            id = id,
            name = name,
            address = address.toAddress(),
            cpf = cpf,
            isValidCpf = isValidCpf
        )

}
