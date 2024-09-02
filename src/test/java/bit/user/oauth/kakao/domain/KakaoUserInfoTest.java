package bit.user.oauth.kakao.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KakaoUserInfoTest {

    @DisplayName("response body로부터 KakaoUserInfo 객체를 생성할 수 있다.")
    @Test
    void kakaoUserInfoOfTest() throws Exception {
        // given
        JsonNode jsonNodeSample = createSampleJsonNode();

        // when
        KakaoUserInfo kakaoUserInfo = KakaoUserInfo.of(jsonNodeSample);

        // then
        assertThat(kakaoUserInfo).extracting(
                "connectedAt",
                "email",
                "nickname"
        ).containsExactly(
                OffsetDateTime.parse(jsonNodeSample.get("connected_at").asText()).toLocalDateTime(),
                jsonNodeSample.get("kakao_account").get("email").asText(),
                jsonNodeSample.get("properties").get("nickname").asText()
        );
    }

    private JsonNode createSampleJsonNode() throws Exception {
        String jsonString = "{"
                + "\"id\": 3663332253,"
                + "\"connected_at\": \"2024-08-21T08:31:04Z\","
                + "\"properties\": {"
                + "\"nickname\": \"박준형\""
                + "},"
                + "\"kakao_account\": {"
                + "\"profile_nickname_needs_agreement\": false,"
                + "\"profile\": {"
                + "\"nickname\": \"박준형\","
                + "\"is_default_nickname\": false"
                + "},"
                + "\"has_email\": true,"
                + "\"email_needs_agreement\": false,"
                + "\"is_email_valid\": true,"
                + "\"is_email_verified\": true,"
                + "\"email\": \"pjh971212@gmail.com\""
                + "}"
                + "}";

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(jsonString);

    }

}