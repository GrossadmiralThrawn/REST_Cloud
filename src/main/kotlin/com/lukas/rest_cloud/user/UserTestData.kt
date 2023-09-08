package com.lukas.rest_cloud.user




import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.Date
import java.util.*




@Configuration
class UserTestData {
    @Bean //Offizielle Beschreibung von @Bean: Eine Funktion, die in einem IoC (Inversion of Control-Container)
    //instanziiert wird.
    fun insertInDatabase (repository: UserRepository): CommandLineRunner
    {
        val obi_Wan = UserData("Obi-Wan", "Kenobi", Date(1980, Calendar.SEPTEMBER, 18), "High_Ground", "A_certain point_of vi102w", "obi-wan@halfer.jediorder");
        val anakin  = UserData("Anakin", "Skywalker", Date(2000, Calendar.MAY, 4), "Underestimated_Power", "Big_Brathuhn", "My_new_empire@jointhedarkside.sithlord");
        val nameList = listOf(obi_Wan, anakin)



        repository.saveAll(nameList)



        return CommandLineRunner {nameList}
    }
}