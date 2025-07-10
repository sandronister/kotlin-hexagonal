package com.sandroni.hexagonal.config

import com.sandroni.hexagonal.adapters.out.FindCustormerByIdADP
import com.sandroni.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdADP: FindCustormerByIdADP)=
         FindCustomerByIdUseCase(findCustomerByIdADP)

}