package bit.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bit.user.dto.UserDto;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("userDto 객체로 생성할 수 있다.")
    @Test
    void createTest() {
        // given
        UserDto userDto = UserDto.builder()
                .email("pjhwork97@gmail.com")
                .nickName("AIJoBumSuk")
                .gender("M")
                .platform("kakao")
                .build();

        // when
        User user = User.from(userDto);

        // then
        assertThat(user).extracting(
                "email",
                "nickName",
                "gender",
                "platform"
        ).containsExactly(
                "pjhwork97@gmail.com",
                "AIJoBumSuk",
                "M",
                "kakao"
        );
    }

}