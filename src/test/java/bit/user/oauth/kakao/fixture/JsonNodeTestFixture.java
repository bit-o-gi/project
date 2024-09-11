package bit.user.oauth.kakao.fixture;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodeTestFixture {

    public static JsonNode createSampleJsonNode() throws Exception {
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
