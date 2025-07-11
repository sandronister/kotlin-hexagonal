package com.sandroni.hexagonal.application.ports.`in`

import com.sandroni.hexagonal.application.core.domain.Customer

interface UpdateCustomerPortIN {

    fun update(customer : Customer,zipcode :String)
}