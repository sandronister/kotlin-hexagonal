package com.sandroni.hexagonal.application.ports.out

import com.sandroni.hexagonal.application.core.domain.Customer

interface FindCustomerByIdPortOUT {

    fun find(id: String): Customer?

}