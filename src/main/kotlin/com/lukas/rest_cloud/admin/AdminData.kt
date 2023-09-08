package com.lukas.rest_cloud.admin




import jakarta.persistence.*
import java.util.Date




@Entity
@Table
data class AdminData(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val adminID:               Long,
    var adminFirstName:        String,
    var adminLastName:         String,
    var adminDateOfBirth:      Date,
    var adminEMail:            String,
    var adminUsername:         String,
    var adminPassword:         String,
    var adminPhoneNumber:      Long,
    var adminMobilePhone:      Long)
