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
    var adminPhoneNumber:      String,
    var adminMobilePhone:      String)
{
    constructor(constructorAdminFirstName: String, constructorAdminLastName: String, constructorAdminDateOfBirth: Date,
                constructorAdminEMail: String, constructorAdminUsername: String, constructorAdminPassword: String,
                constructorAdminPhoneNumber: String, constructorAdminMobilePhone: String):
            this (0, adminFirstName = constructorAdminFirstName, adminLastName = constructorAdminLastName, adminDateOfBirth = constructorAdminDateOfBirth, adminEMail = constructorAdminEMail,
                adminUsername = constructorAdminUsername, adminPassword = constructorAdminPassword, adminPhoneNumber = constructorAdminPhoneNumber,
                adminMobilePhone = constructorAdminMobilePhone)
}
