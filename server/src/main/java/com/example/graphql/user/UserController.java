package com.example.graphql.user;


import com.example.graphql.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginInput loginInput){
        User user = userService.findByUserName(loginInput.getName());
        String token = jwtTokenProvider.createToken(user.getName(), Collections.emptyList());

        return ResponseEntity.ok(token);
    }
}
