package com.company.economics.finance.adapter.`in`

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import com.company.economics.finance.application.FinanceService

@RestController
class FinanceController(
    private val financeService: FinanceService
) {

    @GetMapping("/finance/{id}")
    fun getFinanceRecord(@PathVariable id: Long) {
        println("id : + $id")
    }
}