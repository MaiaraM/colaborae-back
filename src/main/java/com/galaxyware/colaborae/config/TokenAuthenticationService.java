package com.galaxyware.colaborae.config;

import com.galaxyware.colaborae.model.UserModel;
import com.galaxyware.colaborae.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TokenAuthenticationService {

    static final long EXPIRATION_TIME = 860_000_000;
    static final String SECRET = "MySecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";
    static final String AUTHORITIES_KEY = "Authorities";


    @Autowired
    protected UserRepository userRepository;

    public void addAuthentication(HttpServletResponse response, Authentication auth) {
        //We need to add our users authorities to their token so we can restrict certain API's
        String authorities = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        String JWT = Jwts.builder()
                .setSubject(auth.getName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    public Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader(HEADER_STRING);
        if(token != null){

            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""));
            String user = claims.getBody().getSubject();
            UserModel u = userRepository.findByUsername(user);
            String authorities = claims.getBody().get(AUTHORITIES_KEY, String.class);
            String credential = u != null? String.valueOf(u.getUuid()) :null;
            if (user != null) {
                List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
                return new UsernamePasswordAuthenticationToken(user, credential, authorityList);
            }

        }
        return null;
    }
}
