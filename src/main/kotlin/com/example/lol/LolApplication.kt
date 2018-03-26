package com.example.lol

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class LolApplication

fun main(args: Array<String>) {
    SpringApplication.run(LolApplication::class.java, *args)
}
