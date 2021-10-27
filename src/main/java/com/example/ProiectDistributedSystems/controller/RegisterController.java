package com.example.ProiectDistributedSystems.controller;

import com.example.ProiectDistributedSystems.DTO.LoginResponse;
import com.example.ProiectDistributedSystems.DTO.RegisterRequest;
import com.example.ProiectDistributedSystems.DTO.RegisterResponse;
import com.example.ProiectDistributedSystems.model.Admin;
import com.example.ProiectDistributedSystems.model.NormalUser;
import com.example.ProiectDistributedSystems.repository.AdminRepository;
import com.example.ProiectDistributedSystems.repository.NormalUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RegisterController {


    private final NormalUserRepository normalUserRepository;
    private final AdminRepository adminRepository;


    public RegisterController(NormalUserRepository normalUserRepository, AdminRepository adminRepository) {
        this.normalUserRepository = normalUserRepository;
        this.adminRepository = adminRepository;
    }


    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        System.out.println("got a register request");
        RegisterResponse registerResponse = new RegisterResponse();

        NormalUser user = normalUserRepository.findFirstByNameAndPassword(registerRequest.name, registerRequest.password);
        Admin admin = adminRepository.findFirstByNameAndPassword(registerRequest.name, registerRequest.password);

        System.out.println("registerRequest : " + registerRequest.toString());
        System.out.println("user : " + user);
        System.out.println("admin : " + admin);

        if (user == null && admin == null) {
            user = new NormalUser();
            user.setEmail(registerRequest.email);
            user.setName(registerRequest.name);
            user.setPassword(registerRequest.password);

            System.out.println("user = " + user.toString());
            normalUserRepository.save(user);


            registerResponse.registered = true;
            registerResponse.status = "" + HttpStatus.CREATED;
        } else {
            registerResponse.registered = false;
            registerResponse.status = " 400 : " + HttpStatus.BAD_REQUEST;
        }

        return registerResponse;
    }

}
