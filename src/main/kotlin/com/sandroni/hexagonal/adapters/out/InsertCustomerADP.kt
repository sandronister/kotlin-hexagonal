package com.sandroni.hexagonal.adapters.out

import com.sandroni.hexagonal.adapters.out.repository.CustomerRepository
import com.sandroni.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.sandroni.hexagonal.application.core.domain.Customer
import com.sandroni.hexagonal.application.ports.out.InsertCustomerPortOUT
import org.springframework.stereotype.Component

@Component
class InsertCustomerADP(
    private val customerRepository: CustomerRepository
) : InsertCustomerPortOUT{

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}