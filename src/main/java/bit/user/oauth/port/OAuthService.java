package bit.user.oauth.port;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;

public interface OAuthService {
    String getToken(String code, String clientId, String redirectUri, String clientSecret)
            throws JsonProcessingException;

    HttpStatus getUserInfo(String token) throws JsonProcessingException;
}
