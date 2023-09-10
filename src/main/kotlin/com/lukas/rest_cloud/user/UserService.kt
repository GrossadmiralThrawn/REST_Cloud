package com.lukas.rest_cloud.user




import org.jetbrains.annotations.NotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Objects
import java.util.Optional
import kotlin.IllegalStateException




@Service
class UserService(@Autowired private val userRepository: UserRepository) {
    fun showUser(): List<UserData> {
        return userRepository.findAll()
    }




    fun addUser(user: UserData) {
        val studentOptional: Optional<UserData> = userRepository.findUserDataByEMail(user.userEMail)


        if (studentOptional.isPresent)
        {
            throw IllegalStateException("Leider existiert dieser Nutzer bereits.")
        }


        userRepository.save(user)
    }




    fun deleteUser (@NotNull user_ID: Long) {
        if (!userRepository.existsById(user_ID))
        {
            throw IllegalStateException("Leider existiert dieser Nutzer nicht oder er wurde schon gelöscht.")
        }


        userRepository.deleteById(user_ID)
    }




    @Transactional
    fun update_User(userID: Long, userName: String, eMail: String) {
        val user: Optional<UserData> = userRepository.findById(userID)


        if (!user.isPresent) {
            throw IllegalStateException ("Nutzer konnte nicht gefunden werden.")
        }



        val existing_User = user.get()



        if (userName != null && userName.length > 0 && !Objects.equals(user.get(), userName))
        {
            existing_User.userName = userName
            userRepository.save(existing_User)
        }


        if (eMail != null && eMail.length > 0 && !Objects.equals(user.get(), eMail))
        {
            existing_User.userEMail = eMail
            userRepository.save(existing_User)
        }
    }




    @Transactional
    fun updateRealName(userId: Long, firstName: String, lastName: String) {
        val user = userRepository.findById(userId)


        if (!user.isPresent)
        {
            throw IllegalStateException("Leider konnte der angegebene Nutzer nicht gefunden werden.")
        }


        val updateUser = user.get()



        if (firstName != null && firstName.length > 0 && !Objects.equals(updateUser.userFirstName, firstName))
        {
            updateUser.userFirstName = firstName


            userRepository.save(updateUser)
        }



        if (lastName != null && lastName.length > 0 && !Objects.equals(updateUser, lastName))
        {
            updateUser.userLastName = lastName


            userRepository.save(updateUser)
        }
    }
}