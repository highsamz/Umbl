package br.com.fiap.umbl.controller;

import br.com.fiap.umbl.domain.User;
import br.com.fiap.umbl.service.security.TokenService;
import br.com.fiap.umbl.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
              user.getEmail(), user.getSenha()
        );
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.createToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User register (@RequestBody User user){
        User newUser = userService.save(user);
        return newUser;
    }
}
