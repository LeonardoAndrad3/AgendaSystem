package ivana.charis.agenda.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

@Service
public class TokenService{

    @Value("${api.security.token.secret}")
    private String secret;

    public <T extends GeneratedUser> String generatedToken(T user){

        var finalUser = user.generatedUser();
        try{
            var algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer("API agenda.charis")
                    .withSubject(finalUser.email())
                    .withClaim("name", finalUser.name())
                    .withClaim("role", finalUser.role())
                    .withClaim("work", finalUser.work() != null ? finalUser.work().toString() : null)
                    .withClaim("id", finalUser.id())
                    .withExpiresAt(dataExpires())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    public String getSubject(String tokenJWT){
        try{
            var algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("API agenda.charis")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    public Map<String, Claim> getClaims(String tokenJWT){
        try{
            var algoritmo = Algorithm.HMAC256(secret);

            return JWT.require(algoritmo)
                    .withIssuer("API agenda.charis")
                    .build()
                    .verify(tokenJWT)
                    .getClaims();
        } catch (JWTVerificationException e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    private Instant dataExpires() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
