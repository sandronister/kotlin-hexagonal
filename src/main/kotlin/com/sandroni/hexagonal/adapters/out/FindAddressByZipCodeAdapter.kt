package com.sandroni.hexagonal.adapters.out

import com.sandroni.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.sandroni.hexagonal.application.core.domain.Address
import com.sandroni.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
) : FindAddressByZipCodeOutputPort {


    override fun find(zipCode: String) =
        findAddressByZipCodeClient.find(zipCode).toAddress()



}