package com.lukas.rest_cloud.admin




import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service




@Service
class AdminService(@Autowired adminRepository: AdminRepository)