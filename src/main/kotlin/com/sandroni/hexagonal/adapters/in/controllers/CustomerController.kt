package com.sandroni.hexagonal.adapters.`in`.controllers

import com.sandroni.hexagonal.adapters.`in`.controllers.request.CustomerRequest
import com.sandroni.hexagonal.adapters.`in`.controllers.response.CustomerResponse
import com.sandroni.hexagonal.application.core.domain.Customer
import com.sandroni.hexagonal.application.ports.`in`.FindCustomerByIdPortIN
import com.sandroni.hexagonal.application.ports.`in`.InsertCustomerPortIN
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class CustomerController(
    private val insertCustomerPortIN: InsertCustomerPortIN,
    private val findCustomerByIdPortIN: FindCustomerByIdPortIN
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody request: CustomerRequest) {
        with(request){
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerPortIN.insert(customer, zipcode)
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(id: String) : CustomerResponse{
        val customer = findCustomerByIdPortIN.find(id)
        return CustomerResponse(customer)
    }
}