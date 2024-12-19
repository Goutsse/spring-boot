package main.java.auth_service.example.auth_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/token")
    public Map<String, String> generateToken(@RequestParam String username) {
        String token = jwtUtil.generateToken(username);
        return Map.of("token", token);
    }
}
