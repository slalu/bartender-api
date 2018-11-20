package com.lalu.bartender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BartenderServiceApplication

//MVP
//TODO Tests
//TODO Github
//TODO Swagger
//TODO Trello
//TODO Complete Repository operations
//TODO Version package

//References
//Google API naming conventions: https://cloud.google.com/apis/design/naming_convention
//Recipe example: https://www.programcreek.com/java-api-examples/index.php?source_dir=Cooking-to-Goal-master/src/com/customfit/ctg/model/Recipe.java#
//Kotlin with SQLLite: http://androidpala.com/kotlin-sqlite-database/
//Exposed - Kotlin SQL Library: https://github.com/JetBrains/Exposed
//Useful example: https://stackoverflow.com/questions/50339016/kotlin-exposed-dsl-query-mapping
//Licenses:
//https://en.wikipedia.org/wiki/Comparison_of_free_and_open-source_software_licenses
//https://medium.com/shakuro/software-licenses-explained-77f4f18ebeb1

fun main(args: Array<String>) {
    runApplication<BartenderServiceApplication>(*args)
}
