package com.sandroni.hexagonal.application.ports.`in`

import com.sandroni.hexagonal.application.core.domain.Customer

interface InsertCustomerPortIN {

    fun insert(customer: Customer,zipcode: String)
}