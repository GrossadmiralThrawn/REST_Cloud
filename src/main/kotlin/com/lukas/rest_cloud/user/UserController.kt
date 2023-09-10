package com.lukas.rest_cloud.user




import org.jetbrains.annotations.NotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController




/**
 * @author Lukas Philipp Diettrich
 * @constructor Übergabe einer Referenz auf einen User-Service würde nicht funktionieren, da keine Instanz
 *              dieses Objekts vorhanden ist. Könnte über new gelöst werden. Jedoch sollte man Abhängigkeiten
 *              innerhalb einer Klasse vermeiden, weswegen es sinnvoll ist mögliche Übergabeparameter von
 *              dem Erzeuger übergeben zu lassen. Somit vermeidet man Erzeugungsabhängigkeiten und im besten
 *              Fall auch Verwendungsabhängigkeiten, da man so auch Interfaces erstellen und beim Erzeugen als
 *              Übergabeparameter einsetzen kann, was wiederum mehrere Implementierungen einer
 *              Sache erlaubt (z.B. mehrere Datenbankanbindungen).
 *              Ein gutes Beispiel wären Rohstoff-/ Waffenhändler in Videospielen. Wenn alles im Charakter erstellt
 *              werden würde müsste man noch redundante Händlerkommunikation im Code hinzufügen, während
 *              über diese Methode der den Händler betreffende Code (Schöllkraut-Stack-) Dekrementierung
 *              im Händler erledigt werden kann.
 *              Autowired sagt in diesem Fall, dass die Variable "magisch" im Hintergrund instanziiert werden soll.
 */
@RestController //Controller für HTML und RestController für REST, also JSON und XML
@RequestMapping(path = ["lukasCloud/user_start"])
class UserController (@Autowired private val userService: UserService) {
    @GetMapping (path = ["/show_User"])
    fun showUser(): List<String> {
        return listOf(listOf(userService.showUser()).toString())
    }




    @RequestMapping(path = ["/hello"]) //Ist allgemeinere Version. Kann verschiedene Ausprägungen haben und für verschiedene http-Requests (get, put, ...) verwendet werden.
    fun hello(): String
    {
        return "Hallo Welt!" //Wenn List<String> und listof("Hallo", "Welt!") genommen wird, dann wird eine JSON-Datei zurückgegeben.
    }




    @GetMapping("/login")
    fun login(): String {
        return "login"
    }




    @PostMapping(path = ["/register"])
    fun registerUser(@RequestBody user: UserData) {
        userService.addUser(user)
    }




    @DeleteMapping(path = ["/delete/{id}"])
    fun deleteUser(@NotNull @PathVariable("id") user_ID: Long) {
        userService.deleteUser(user_ID)
    }




    @PutMapping(path = ["/update_username_or_mail/{user_ID}"])
    fun updateUser(@PathVariable("user_ID") user_ID: Long, @RequestParam(required = false) user_Name: String,
                   @RequestParam(required = false) e_Mail: String) {
        userService.update_User(user_ID, user_Name, e_Mail)
    }




    @PutMapping(path = ["/update_name_user/{user_ID}"])
    fun updateRealNames(@PathVariable("user_ID") user_ID: Long,
                        @RequestParam(required = false) first_Name: String,
                        @RequestParam(required = false) last_Name: String) {
        userService.updateRealName(user_ID, first_Name, last_Name)
    }
}