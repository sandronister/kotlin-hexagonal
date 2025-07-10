package com.sandroni.hexagonal.adapters.`in`.controllers.response

import com.sandroni.hexagonal.application.core.domain.Address

class AddressResponse(
    val street : String,
    val city : String,
    val state: String
){
    constructor(address : Address): this(
        street = address.street,
        city = address.city,
        state = address.state
    )
}
