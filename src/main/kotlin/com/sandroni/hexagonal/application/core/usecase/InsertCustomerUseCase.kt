package com.sandroni.hexagonal.application.core.usecase

import com.sandroni.hexagonal.application.core.domain.Customer
import com.sandroni.hexagonal.application.ports.`in`.InsertCustomerPortIN
import com.sandroni.hexagonal.application.ports.out.FindAddressByZipCodePortOUT
import com.sandroni.hexagonal.application.ports.out.InsertCustomerPortOUT

class InsertCustomerUseCase(
    private val findAddressByZipCodePortOUT: FindAddressByZipCodePortOUT,
    private val insertCustomerPortOUT: InsertCustomerPortOUT
) : InsertCustomerPortIN {

    override fun insert(customer: Customer, zipcode : String) {
        customer.apply {
            address = findAddressByZipCodePortOUT.find(zipcode)
        }.let{
            insertCustomerPortOUT.insert(it)
        }
    }
}