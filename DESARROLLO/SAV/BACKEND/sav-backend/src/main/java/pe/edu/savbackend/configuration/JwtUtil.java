package pe.edu.savbackend.configuration;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	static void addAuthentication(HttpServletResponse res, String username) {
		String token = Jwts.builder().setSubject(username)
				.signWith(SignatureAlgorithm.HS512, "key")
				.compact();
		res.addHeader(Constantes.HEADER_STRING, Constantes.TOKEN_PREFIX + token);
	}
	
	static Authentication getAuthentication (HttpServletRequest req) {
		String token = req.getHeader(Constantes.HEADER_STRING);
		
		if(token != null) {
			String user = Jwts.parser()
					.setSigningKey("key")
					.parseClaimsJws(token.replace(Constantes.TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();
			return user != null ? new UsernamePasswordAuthenticationToken(user,  null, Collections.emptyList()):null;
		}
		return null;
	}
}
