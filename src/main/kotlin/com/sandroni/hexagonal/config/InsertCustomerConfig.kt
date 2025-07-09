package com.sandroni.hexagonal.config

import com.sandroni.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.sandroni.hexagonal.adapters.out.InsertCustomerAdapter
import com.sandroni.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.sandroni.hexagonal.application.core.usecase.InsertCustomerUseCase
import com.sandroni.hexagonal.application.ports.`in`.InsertCustomerInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter
    ) = InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter)

}