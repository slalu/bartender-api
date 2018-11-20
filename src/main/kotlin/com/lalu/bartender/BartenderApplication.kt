package com.lalu.bartender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BartenderServiceApplication

//References
//Google API naming conventions: https://cloud.google.com/apis/design/naming_convention
//Exposed - Kotlin SQL Library: https://github.com/JetBrains/Exposed
//Useful example: https://stackoverflow.com/questions/50339016/kotlin-exposed-dsl-query-mapping

fun main(args: Array<String>) {
    runApplication<BartenderServiceApplication>(*args)
}
