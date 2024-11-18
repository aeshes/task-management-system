package org.aoizora.controller;

import org.aoizora.dto.LoginRequest;
import org.aoizora.dto.RegistrationRequest;
import org.aoizora.entity.User;
import org.aoizora.service.AuthenticationService;
import org.aoizora.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class AuthController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    public AuthController(AuthenticationService authenticationService,
                          UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegistrationRequest request) {
        return ResponseEntity.ok().body(userService.registerUser(request));
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return authenticationService.login(request);
    }
}
