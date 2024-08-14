package bit.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
public class UserDto {
    private final Long id;

    private final String email;

    private final String nickName;

    private final String gender;

    private final String platform;

    @Builder
    public UserDto(Long id, String email, String nickName, String gender, String platform) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.gender = gender;
        this.platform = platform;
    }
}
