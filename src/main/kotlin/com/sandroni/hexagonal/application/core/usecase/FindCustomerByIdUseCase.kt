package com.sandroni.hexagonal.application.core.usecase

import com.sandroni.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.sandroni.hexagonal.application.ports.`in`.FindCustomerByIdPortIN
import com.sandroni.hexagonal.application.ports.out.FindCustomerByIdPortOUT

class FindCustomerByIdUseCase(
    private val findCustomerByIDPortOUT: FindCustomerByIdPortOUT
) : FindCustomerByIdPortIN {

    override fun find(id: String) =
         findCustomerByIDPortOUT.find(id) ?: throw ObjectNotFoundException("Customer with id $id not found")

}