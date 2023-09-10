package com.lukas.rest_cloud.admin




import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.text.SimpleDateFormat
import java.util.*


@Configuration
class TestAdmin() {
    @Bean
    fun insertTestAdmins(adminRepository: AdminRepository): CommandLineRunner {
        val yoda                       = AdminData(0, "Master", "Yoda", Date(1980, Calendar.SEPTEMBER, 18), "Ketamin@jedicouncil.jediorder", "GrandmasterYoda", "Do or do not. There is_no try.", "+4915204098827", "+4903450635867")
        val sidious                    = AdminData(0, "Sheev", "Palpatine", Date(1980, Calendar.SEPTEMBER, 18), "emperor@firstgalacticempire.empire", "Your Highness", "It's treason then.", "+4915204098827", "+4903450635867")
        val adminList    = listOf(yoda, sidious)


        adminRepository.saveAll(adminList)


        return CommandLineRunner{adminList}
    }
}