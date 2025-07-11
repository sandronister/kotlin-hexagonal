package com.sandroni.hexagonal.adapters.`in`.controllers

import com.sandroni.hexagonal.adapters.`in`.controllers.request.CustomerRequest
import com.sandroni.hexagonal.adapters.`in`.controllers.response.CustomerResponse
import com.sandroni.hexagonal.application.core.domain.Customer
import com.sandroni.hexagonal.application.ports.`in`.FindCustomerByIdPortIN
import com.sandroni.hexagonal.application.ports.`in`.InsertCustomerPortIN
import com.sandroni.hexagonal.application.ports.`in`.UpdateCustomerPortIN
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/customers")
class CustomerController(
    private val insertCustomerPortIN: InsertCustomerPortIN,
    private val findCustomerByIdPortIN: FindCustomerByIdPortIN,
    private val updateCustomerPortIN: UpdateCustomerPortIN
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
    fun findById(@PathVariable id: String) : CustomerResponse{
        val customer = findCustomerByIdPortIN.find(id)
        return CustomerResponse(customer)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@Valid @RequestBody request: CustomerRequest,@PathVariable id:String) {
        with(request) {
            val customer = Customer(id = id, name = name, cpf = cpf)
            updateCustomerPortIN.update(customer, zipcode)
        }
    }
}