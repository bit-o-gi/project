package bit.user.oauth.port;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface OAuthService {
    String getToken(String code, String clientId, String redirectUri, String clientSecret)
            throws JsonProcessingException;

    String getUserInfo(String token);
}
