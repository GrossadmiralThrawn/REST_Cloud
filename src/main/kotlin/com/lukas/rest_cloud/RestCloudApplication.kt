package com.lukas.rest_cloud




import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication




//Verbindung zu Datenbank in der application.properties-Datei
@SpringBootApplication
class RestCloudApplication

fun main(args: Array<String>) {
    runApplication<RestCloudApplication>(*args)
}
