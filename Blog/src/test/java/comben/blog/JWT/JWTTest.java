package comben.blog.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-07-01
 * Time: 1:34
 */
public class JWTTest {
    public static final Long EXPIRATION = 30 * 60 * 1000L;
    public static final String SECRET_STRING = "xRu9/14STdKLhb9ta3rWvyU/T1JWVXl1DVtpg5jM0Bg=";
    public static final Key KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_STRING));

    @Test
    public void getKey() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println(Encoders.BASE64.encode(key.getEncoded()));
    }

    @Test
    public void generateToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("Id", 1);
        claims.put("Username", "test");

        String taken = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(KEY)
                .compact();
        System.out.println(taken);
    }

    @Test
    public void verifyToken() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJVc2VybmFtZSI6InRlc3QiLCJJZCI6MSwiZXhwIjoxNzE5NzcxMzczfQ.wyLVoFMTKpGmctA7T8QASCKe5mzt1Mt2n7wvyraUq78";
        JwtParserBuilder builder = Jwts.parserBuilder().setSigningKey(KEY);
        Claims claims = builder.build().parseClaimsJws(token).getBody();//签名错误会抛异常，但实际可以解析
        System.out.println(claims);
    }
}
