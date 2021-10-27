package com.example.ProiectDistributedSystems.controller;


import com.example.ProiectDistributedSystems.DTO.LoginRequest;
import com.example.ProiectDistributedSystems.DTO.LoginResponse;
import com.example.ProiectDistributedSystems.model.Admin;
import com.example.ProiectDistributedSystems.model.NormalUser;
import com.example.ProiectDistributedSystems.repository.AdminRepository;
import com.example.ProiectDistributedSystems.repository.NormalUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class LoginController {

    private final NormalUserRepository normalUserRepository;
    private final AdminRepository adminRepository;



    public LoginController(NormalUserRepository normalUserRepository, AdminRepository adminRepository) {
        this.normalUserRepository = normalUserRepository;
        this.adminRepository = adminRepository;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        System.out.println("got a Login request");
        LoginResponse loginResponse =  new LoginResponse(true,true);

        NormalUser usr = normalUserRepository.findFirstByNameAndPassword(loginRequest.name, loginRequest.password);
        Admin admin = adminRepository.findFirstByNameAndPassword(loginRequest.name,loginRequest.password);
        System.out.println("usr : " + usr + "admin : " + admin);
        return loginResponse;
    }

    @GetMapping("/login2")
    public String login2(){
        System.out.println("LOGIN 2");
        return "LOGIN";
    }



}
