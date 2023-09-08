package com.USE.petcareapp.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Key;

import java.util.Date;

@Service
@NoArgsConstructor
public class JwtUtils {
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SecurityConstants.SECRET));
    }

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 3600000))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(key())
                .parseClaimsJws(token).getBody().getSubject();
    }

    public Boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(key()).parse(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
