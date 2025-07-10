package com.sandroni.hexagonal.config

import com.sandroni.hexagonal.adapters.out.FindAddressByZipCodeADP
import com.sandroni.hexagonal.adapters.out.InsertCustomerADP
import com.sandroni.hexagonal.application.core.usecase.InsertCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeADP: FindAddressByZipCodeADP,
        insertCustomerADP: InsertCustomerADP
    ) = InsertCustomerUseCase(findAddressByZipCodeADP, insertCustomerADP)

}