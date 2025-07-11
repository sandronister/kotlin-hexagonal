package com.sandroni.hexagonal.adapters.out

import com.sandroni.hexagonal.adapters.out.repository.CustomerRepository
import com.sandroni.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.sandroni.hexagonal.application.core.domain.Customer
import com.sandroni.hexagonal.application.ports.out.UpdateCustomerPortOUT
import org.springframework.stereotype.Component

@Component
class UpdateCustomerADP(
    private val customerRepository: CustomerRepository
): UpdateCustomerPortOUT {

        override fun update(customer: Customer) {
            customerRepository.save(CustomerEntity(customer))
        }
}