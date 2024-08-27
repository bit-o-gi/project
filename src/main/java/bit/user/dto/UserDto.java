package bit.user.dto;

import bit.user.oauth.kakao.domain.KakaoUserInfo;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserDto {
    private final Long id;

    private final String email;

    private final String nickName;

    private final String gender;

    private final String platform;

    private final LocalDateTime registerDate;

    @Builder
    public UserDto(Long id, String email, String nickName, String gender, String platform, LocalDateTime registerDate) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.gender = gender;
        this.platform = platform;
        this.registerDate = registerDate;
    }

    public static UserDto fromKakaoUser(KakaoUserInfo info) {
        return UserDto.builder()
                .email(info.getEmail())
                .nickName(info.getNickname())
                .platform("kakao")
                .registerDate(info.getConnectedAt())
                .build();
    }
}
