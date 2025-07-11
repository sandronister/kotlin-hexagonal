package com.sandroni.hexagonal.config

import com.sandroni.hexagonal.adapters.out.FindAddressByZipCodeADP
import com.sandroni.hexagonal.adapters.out.UpdateCustomerADP
import com.sandroni.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.sandroni.hexagonal.application.core.usecase.UpdateCustomerUsecase
import com.sandroni.hexagonal.application.ports.`in`.UpdateCustomerPortIN
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findAddressByZipCodeADP: FindAddressByZipCodeADP,
        updateCustomerADP: UpdateCustomerADP,
        findCustomerUsecase: FindCustomerByIdUseCase
    ): UpdateCustomerPortIN =
         UpdateCustomerUsecase(
            findAddressByZipCodeADP,
            updateCustomerADP,
            findCustomerUsecase
        )

}