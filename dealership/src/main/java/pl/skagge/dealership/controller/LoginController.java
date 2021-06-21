package pl.skagge.dealership.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skagge.dealership.auth.LoginCredentials;

@RestController
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {

    @PostMapping
    public void login(@RequestBody LoginCredentials loginCredentials) {
    }
}
