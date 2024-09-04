package bit.user.entity;

import static bit.user.oauth.OauthPlatformStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bit.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserEntityTest {

    @DisplayName("User 객체를 UserEntity로 변환한다.")
    @Test
    void fromTest() {
        // given
        User user = User.builder()
                .id(1L)
                .email("pjh@abcd.com")
                .nickName("MR_JO")
                .platform(KAKAO)
                .build();

        // when
        UserEntity userEntity = UserEntity.from(user);

        // then
        assertThat(user).extracting(
                "id",
                "email",
                "nickName",
                "platform"
        ).containsExactly(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getNickName(),
                userEntity.getPlatform()
        );
    }

}