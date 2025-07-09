package com.sandroni.hexagonal.application.ports.out

import com.sandroni.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {
    fun find(zipCode: String): Address
}