package com.sandroni.hexagonal.adapters.out

import com.sandroni.hexagonal.adapters.out.client.FindAddressByZipCodeCLI
import com.sandroni.hexagonal.application.ports.out.FindAddressByZipCodePortOUT
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeADP(
    private val findAddressByZipCodeClient: FindAddressByZipCodeCLI
) : FindAddressByZipCodePortOUT {


    override fun find(zipCode: String) =
        findAddressByZipCodeClient.find(zipCode).toAddress()



}