package com.kscapser.rest.security.api.jwttoken.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
public class TokenRequest implements Serializable {

    private static final long serialVersionUID = 1562416535849440237L;

    private String algorithm;
    private Map<String, Object> claimJson;
    private String symmetricKey;
    private MultipartFile asymkey;
}
