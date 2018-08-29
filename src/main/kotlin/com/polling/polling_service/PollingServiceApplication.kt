package com.polling.polling_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class PollingServiceApplication

data class Demo(val text: String, val priority: String)

@RestController
class DemoController {
    @RequestMapping("/")
    fun message(): String {
        return "Hello World!"
    }
}

fun main(args: Array<String>) {
    runApplication<PollingServiceApplication>(*args)
}














