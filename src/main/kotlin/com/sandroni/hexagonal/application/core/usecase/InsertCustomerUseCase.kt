package com.sandroni.hexagonal.application.core.usecase

import com.sandroni.hexagonal.application.core.domain.Customer
import com.sandroni.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.sandroni.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.sandroni.hexagonal.application.ports.out.InsertCustomerOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort
) : InsertCustomerInputPort {

    override fun insert(customer: Customer, zipcode : String) {
        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipcode)
        }.let{
            insertCustomerOutputPort.insert(it)
        }
    }
}