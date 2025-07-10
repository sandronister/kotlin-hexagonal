package com.sandroni.hexagonal.application.ports.`in`

import com.sandroni.hexagonal.application.core.domain.Customer

interface FindCustomerByIdPortIN {

    fun find(id: String): Customer
}