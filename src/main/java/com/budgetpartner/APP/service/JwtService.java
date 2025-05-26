package com.budgetpartner.APP.service;

import com.budgetpartner.APP.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;

    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    public String generateToken(final Usuario usuario){
        return buildToken(usuario, jwtExpiration);
    }

    public String generateTokenRefresh(final Usuario usuario){
        return buildToken(usuario, refreshExpiration);
    }

    private String buildToken(final Usuario usuario, final long expiration){
        return Jwts.builder()
                .id(usuario.getId().toString())
                .claims(Map.of("name", usuario.getNombre()))
                .subject(usuario.getId().toString())
                .expiration(new Date(System.currentTimeMillis()+  expiration))
                .signWith(getSignInKey())
                .compact();
    }
    private SecretKey getSignInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);

    }

}
