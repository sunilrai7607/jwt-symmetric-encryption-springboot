package com.kscapser.rest.security.api.jwttoken.controller;


import com.kscapser.rest.security.api.jwttoken.model.TokenRequest;
import com.kscapser.rest.security.api.jwttoken.service.JwtTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/token", produces = MediaType.APPLICATION_JSON_VALUE)
public class JwtTokenController {

    private final JwtTokenService jwtTokenService;

    @Autowired
    public JwtTokenController(JwtTokenService jwtTokenService) {
        this.jwtTokenService = jwtTokenService;
    }


    @PostMapping(value = "/symmetric")
    public ResponseEntity<String> generateSymmetricToken(@RequestBody TokenRequest tokenRequest) throws Exception {
        return ResponseEntity.ok(jwtTokenService.generateToken(tokenRequest));
    }

    @PostMapping(value = "/symmetric/{token}")
    public ResponseEntity<Boolean> generateSymmetricToken(@PathVariable("token") String token, @RequestParam(required = false) String symkey) throws Exception {
        return ResponseEntity.ok(jwtTokenService.verifyToken(token,symkey));
    }
}
