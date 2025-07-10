package com.sandroni.hexagonal.application.ports.out

import com.sandroni.hexagonal.application.core.domain.Customer

interface InsertCustomerPortOUT {
    fun insert(customer : Customer)
}