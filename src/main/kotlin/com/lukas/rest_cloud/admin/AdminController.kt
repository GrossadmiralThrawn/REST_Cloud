package com.lukas.rest_cloud.admin




import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*




@RestController
@RequestMapping(path = ["lukasCloud/adminStart"])
class AdminController(@Autowired private val adminService: AdminService) {
    //Ist allgemeinere Version. Kann verschiedene Ausprägungen haben und für verschiedene http-Requests (get, put, ...) verwendet werden.
    //GetMapping liefert hingegen von vornherein die richtige http-Annotation.
    @GetMapping(path = ["/helloAdmin"])
    fun helloAdmin(): List<String>{
        return listOf("Hello Admin")
    }
}