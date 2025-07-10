package com.sandroni.hexagonal.adapters.out

import com.sandroni.hexagonal.adapters.out.repository.CustomerRepository
import com.sandroni.hexagonal.application.core.domain.Customer
import com.sandroni.hexagonal.application.ports.out.FindCustomerByIdPortOUT
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustormerByIdADP(
    private val customerRepository: CustomerRepository
) : FindCustomerByIdPortOUT {

    override fun find(id: String): Customer? =
         customerRepository.findById(id)
            .getOrNull()
            .let{
                return it?.toCustomer()
            }
}