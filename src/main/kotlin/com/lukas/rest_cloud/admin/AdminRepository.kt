package com.lukas.rest_cloud.admin




import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository




@Repository
interface AdminRepository : JpaRepository<AdminData, Long>