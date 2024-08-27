package bit.user.domain;

import bit.user.dto.UserDto;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class User {
    private final Long id;
    private final String email;
    private final String nickName;
    private final String gender;
    private final String platform;
    private final LocalDateTime registerDate;

    @Builder
    public User(Long id, String email, String nickName, String gender, String platform, LocalDateTime registerDate) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.gender = gender;
        this.platform = platform;
        this.registerDate = registerDate;
    }

    public static User from(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .nickName(userDto.getNickName())
                .gender(userDto.getGender())
                .platform(userDto.getPlatform())
                .registerDate(userDto.getRegisterDate())
                .build();
    }
}
