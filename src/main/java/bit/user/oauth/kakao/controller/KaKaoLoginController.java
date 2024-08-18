package bit.user.oauth.kakao.controller;

import bit.user.oauth.port.OAuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class KaKaoLoginController {

    private final OAuthService oAuthService;

    @Value("${kakao.client.id}")
    String clientId;
    @Value("${kakao.redirect.uri}")
    String redirectUri;
    @Value("${kakao.client.secret}")
    String clientSecret;

    @GetMapping("/kakao")
    public String getAuthKakao() {
        return "https://kauth.kakao.com/oauth/authorize?"
                + "client_id=" + clientId
                + "&redirect_uri=" + redirectUri
                + "&response_type=code"
                + "&scope=account_email";
    }

    @PostMapping("/kakao/token")
    public String postAuthKakao(@RequestBody MultiValueMap<String, String> params) throws JsonProcessingException {
        String code = params.getFirst("code");
        return oAuthService.getToken(code, clientId, redirectUri, clientSecret);
    }

    @PostMapping("/kakao/access")
    public String postGetUserInfo(@RequestBody String accessToken) throws JsonProcessingException {
        return oAuthService.getUserInfo(accessToken);
    }
}
