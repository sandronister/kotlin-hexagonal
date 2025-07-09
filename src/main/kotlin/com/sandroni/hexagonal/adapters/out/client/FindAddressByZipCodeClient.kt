package com.sandroni.hexagonal.adapters.out.client

import com.sandroni.hexagonal.adapters.out.client.response.AddressResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "findAddressByZipCodeClient",
    url = "\${sandroni.client.address.url}",
)
interface FindAddressByZipCodeClient {

    @GetMapping("/{zipcode}")
    fun find(@PathVariable zipcode: String): AddressResponse
}