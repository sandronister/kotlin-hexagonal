package com.sandroni.hexagonal.adapters.out

import com.sandroni.hexagonal.adapters.out.repository.CustomerRepository
import com.sandroni.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.sandroni.hexagonal.application.core.domain.Customer
import com.sandroni.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
) : InsertCustomerOutputPort{

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}