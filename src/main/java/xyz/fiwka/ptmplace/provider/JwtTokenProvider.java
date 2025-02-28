package xyz.fiwka.ptmplace.provider;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import xyz.fiwka.ptmplace.configuration.JwtProperties;
import xyz.fiwka.ptmplace.dto.response.TokenResponseDto;

import java.security.Key;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
public class JwtTokenProvider implements TokenProvider {

    private final Key key;
    private final JwtProperties jwtProperties;

    public JwtTokenProvider(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        this.key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtProperties.secretKey().getBytes()));
    }

    @Override
    public TokenResponseDto generateTokens(String email) {
        return new TokenResponseDto(
                createToken(email, jwtProperties.getAccessExpiration(), JwtProperties.ACCESS_PREFIX),
                jwtProperties.getAccessExpiration(),
                createToken(email, jwtProperties.getRefreshExpiration(), JwtProperties.REFRESH_PREFIX),
                jwtProperties.getRefreshExpiration()
        );
    }

    private String createToken(String email, long tokenExpiration, String tokenType) {
        Date now = new Date();
        Date lifetime = new Date(now.getTime() + tokenExpiration);

        return Jwts.builder()
                .subject(email)
                .issuedAt(now)
                .expiration(lifetime)
                .signWith(key)
                .claim(JwtProperties.TOKEN_TYPE, tokenType)
                .compact();
    }
}
