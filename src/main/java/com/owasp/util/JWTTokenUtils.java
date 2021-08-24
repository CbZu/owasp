package com.owasp.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.owasp.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenUtils {
    public static final String API_SECRET_KEY = "secrectKey";

    public static final long TOKEN_VALIDITY = 2 * 60 * 1000;

    public static Map<String, String> generateJWTToken(User user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + TOKEN_VALIDITY)).claim("userId", user.getId())
                .claim("email", user.getEmail()).claim("firstName", user.getFirstName())
                .claim("lastName", user.getLastName()).compact();
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        return map;
    }
}
