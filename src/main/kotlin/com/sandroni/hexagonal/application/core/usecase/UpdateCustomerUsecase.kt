package com.sandroni.hexagonal.application.core.usecase

import com.sandroni.hexagonal.application.core.domain.Customer
import com.sandroni.hexagonal.application.ports.`in`.FindCustomerByIdPortIN
import com.sandroni.hexagonal.application.ports.`in`.UpdateCustomerPortIN
import com.sandroni.hexagonal.application.ports.out.FindAddressByZipCodePortOUT
import com.sandroni.hexagonal.application.ports.out.FindCustomerByIdPortOUT
import com.sandroni.hexagonal.application.ports.out.UpdateCustomerPortOUT

class UpdateCustomerUsecase(
    private val findAddressByZipCodePortOUT: FindAddressByZipCodePortOUT,
    private val updateCustomerPortOUT: UpdateCustomerPortOUT,
    private val findCustomerByIdPortIN: FindCustomerByIdPortIN
) : UpdateCustomerPortIN {

    override fun update(customer: Customer, zipcode: String) {
        if (customer.id == null) throw IllegalArgumentException("Customer ID must not be null")
        findCustomerByIdPortIN.find(customer.id)

        customer.apply {
            address = findAddressByZipCodePortOUT.find(zipcode)
        }.let {
            updateCustomerPortOUT.update(customer)
        }
    }

}


