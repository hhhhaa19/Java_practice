package comben.blog.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-07-01
 * Time: 2:11
 */
@Slf4j
public class JWTUtils {
    private static final Long EXPIRATION = 30 * 60 * 1000L;
    private static final String SECRET_STRING = "xRu9/14STdKLhb9ta3rWvyU/T1JWVXl1DVtpg5jM0Bg=";//要确保重启后一致
    private static final Key KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_STRING));

    public static  String generateToken(Map<String, Object> claims) {
        String taken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(KEY)
                .compact();
        return taken;
    }

    public static  Claims verifyToken(String token) {
        JwtParserBuilder builder = Jwts.parserBuilder().setSigningKey(KEY);
        Claims claims = null;
        try {
            claims = builder.build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error("Error parsing token", e);
        }
        return claims;
    }
}
