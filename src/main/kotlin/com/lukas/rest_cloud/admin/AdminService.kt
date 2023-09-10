package com.lukas.rest_cloud.admin




import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service




@Service
class AdminService(@Autowired private val adminRepository: AdminRepository)
{

    fun checkForSecurityPhoneNumber(phoneNumber: Int): Boolean {
        if (phoneNumber == 110 || phoneNumber == 111 || phoneNumber == 112)
        {
            return true
        }


        return false
    }



    fun findAdminDataByAdminMobilePhone(phoneNumber: String){
        //^ = Start, .{1} außer Zeilenumbruch ein beliebiges Zeichen, + eins oder mehr Zeichen, $ Ende des Strings
        val regex = "\\+[0-9]{4,}$".toRegex()


        if (phoneNumber.length > 2 && ((phoneNumber.startsWith("+") && phoneNumber.matches(regex)) || checkForSecurityPhoneNumber(phoneNumber.toInt())))
        {
             adminRepository.findAdminDataByAdminMobilePhone(phoneNumber)
        }
    }
}