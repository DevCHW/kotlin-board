package com.example.ktboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.TimeZone

@SpringBootApplication
class KtboardApplication

fun main(args: Array<String>) {
    runApplication<KtboardApplication>(*args)
    TimeZone.setDefault(TimeZone.getTimeZone("US/Pacific"))
}

