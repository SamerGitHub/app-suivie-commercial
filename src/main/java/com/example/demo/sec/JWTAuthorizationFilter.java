package com.example.demo.sec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chaine)
            throws ServletException, IOException {
        //  System.out.println("Filtering on...........................................................");

        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "*");

        response.addHeader("Access-Control-Allow-Headers",
                "Origin, Accept, X-Requested-With, Content-Type," + " Access-Control-Request-Method, "
                        + " Access-Control-Request-Headers, "

                        + "Authorization");

        response.addHeader("Access-Control-Expose-Headers",
                "Access-Control-Allow-Origin, Access-Control-Allow-Credentials, Authorization");

        String header = request.getHeader(SecurityConstant.HEADER_STRING);
        System.out.println("header : " + header);
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            if (header == null || !header.startsWith(SecurityConstant.TOKEN_PREFIX)) {
                chaine.doFilter(request, response);
                return;
            }
            Claims claims = Jwts.parser().setSigningKey(SecurityConstant.SECRET)
                    .parseClaimsJws(header.replace(SecurityConstant.TOKEN_PREFIX, "")).getBody();
            String username = claims.getSubject();
            ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claims.get("roles");
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            roles.forEach(ro -> {
                authorities.add(new SimpleGrantedAuthority(ro.get("authority")));
            });
            UsernamePasswordAuthenticationToken authentificationToken = new UsernamePasswordAuthenticationToken(
                    username, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentificationToken);
            chaine.doFilter(request, response);

        }
    }
}
