package com.kscapser.rest.security.api.jwttoken.service;

import com.kscapser.rest.security.api.jwttoken.model.TokenRequest;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Slf4j
@Service
public class JwtTokenService {

    private final JacksonJsonParser jsonParser;

    @Autowired
    public JwtTokenService(JacksonJsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    /**
     * Method to generate token Symmetric Encryption
     * @param tokenRequest
     * @return
     */
    public String generateToken(TokenRequest tokenRequest) throws Exception{
        try {
            return createSymmetricToken(jwtBuilder(tokenRequest.getClaimJson()),algorithm("HS256"),tokenRequest.getSymmetricKey());
        } catch (Exception e) {
            log.info("UnsupportedEncodingException : {} ",e.getMessage());
            throw new UnsupportedEncodingException("Symmetric Encryption token generation failed");
        }
    }

    private JwtBuilder jwtBuilder(Map<String, Object> claimsJson) {
        return Jwts.builder().setClaims(claimsJson);
    }

    private String createSymmetricToken(JwtBuilder jwtBuilder, SignatureAlgorithm signatureAlgorithm, String symkey) throws UnsupportedEncodingException {
        return jwtBuilder.signWith(signatureAlgorithm,symkey.getBytes("UTF-8")).compact();
    }

    private SignatureAlgorithm algorithm(final String algorithm) {
        try {
            return SignatureAlgorithm.valueOf(algorithm);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unsupported signature algorithm");
        }
    }

    /**
     * Method to verify the token
     *
     * @param s
     * @param token
     * @return
     */
    public Boolean verifyToken(String s, final String token) {
        return null;
    }
}
