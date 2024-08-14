package bit.user.oauth.kakao.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class KaKaoController {

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
                + "&response_type=code";
    }

    @PostMapping("/kakao/token")
    public String postAuthKakao(@RequestBody MultiValueMap<String, String> params) {
        String code = params.getFirst("code");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        MultiValueMap<String, String> httpBody = new LinkedMultiValueMap<>();
        httpBody.add("grant_type", "authorization_code");
        httpBody.add("client_id", clientId);
        httpBody.add("redirect_uri", redirectUri);
        httpBody.add("code", code);
        httpBody.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(httpBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(
                "https://kauth.kakao.com/oauth/token", httpEntity, String.class
        );

        System.out.println(response.getBody());
        return response.getBody();
    }
}
