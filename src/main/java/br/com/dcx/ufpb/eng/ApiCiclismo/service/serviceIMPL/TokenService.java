package br.com.dcx.ufpb.eng.ApiCiclismo.service.serviceIMPL;


import br.com.dcx.ufpb.eng.ApiCiclismo.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create().withIssuer("Ciclismo-API").
                    withSubject(user.getEmail()).withExpiresAt(genExpirationDate()).sign(algorithm);
        return token;
        }catch (JWTCreationException jwtCreationException){
            throw new RuntimeException("Error while generating token");
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm).withIssuer("Ciclismo-API").build().verify(token).getSubject();
        }catch (JWTVerificationException jwtVerificationException){
            return " ";

        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}