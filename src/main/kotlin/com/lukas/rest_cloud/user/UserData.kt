package com.lukas.rest_cloud.user



import jakarta.persistence.*
import java.sql.Date




@Entity //Definiert eine Klasse, die Daten mit einer Tabelle austauschen kann.
@Table  //Erlaubt es die Details zu spezifizieren, die zu der Tabelle gehören.
data class UserData(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userID:           Long,
    var userFirstName:    String,
    var userLastName:     String,
    val userDateOfBirth:  Date,
    var userName:         String,
    var userPassword:     String,
    var userEMail:        String,) //Mit @Transient könnte man noch das Alter errechnen lassen ohne es in dem DBS abzulegen.
{
    constructor(
        firstName:    String,
        lastName:     String,
        dateOfBirth:  Date,
        userName:     String,
        userPassword: String,
        eMail:        String
    ): this(
        userID = 0, // Set to 0 to let the database generate the ID
        userFirstName    = firstName,
        userLastName     = lastName,
        userDateOfBirth  = dateOfBirth,
        userName     = userName,
        userPassword = userPassword,
        userEMail        = eMail
    )
}
