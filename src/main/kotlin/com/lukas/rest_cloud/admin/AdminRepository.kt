package com.lukas.rest_cloud.admin




import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional




@Repository
interface AdminRepository: JpaRepository<AdminData, Long>
{
    @Query("SELECT aD FROM AdminData aD WHERE aD.adminPhoneNumber = ?1")
    fun findAdminDataByAdminMobilePhone(phoneNumber: String): Optional<AdminData>
}