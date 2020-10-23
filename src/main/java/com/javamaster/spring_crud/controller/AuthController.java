package com.javamaster.spring_crud.controller;

import com.javamaster.spring_crud.config.jwt.JwtProvider;
import com.javamaster.spring_crud.entity.UserEntity;
import com.javamaster.spring_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@org.jetbrains.annotations.NotNull @RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity user = new UserEntity();
        user.setLogin(registrationRequest.getLogin());
        user.setPassword(registrationRequest.getPassword());
        userService.saveUser(user);

        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());

        return new AuthResponse(token);
    }
}