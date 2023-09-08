package com.lukas.rest_cloud.user




import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional




@Repository //Dient der Erfassung des Datentyps und des Primärschlüssels dessen. Es sollen also die
//entsprechenden Datentypen erfasst werden und eine Hilfe gestellt werden, um damit zu arbeiten.
//Zusätzlich werden alle Erweiterungen des Interfaces erfasst.
interface UserRepository: JpaRepository<UserData, Long> {
    //SELECT * FROM Student_Data WHERE e-Mail = ?
    @Query("SELECT uD FROM UserData uD WHERE uD.userEMail = ?1") //Frame-Work-spezifisch.
    fun findUserDataByEMail(testMail: String): Optional<UserData>
}